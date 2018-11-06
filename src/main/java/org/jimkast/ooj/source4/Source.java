package org.jimkast.ooj.source4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.map.BiMapping;
import org.jimkast.ooj.map.MappedKey;
import org.jimkast.ooj.map.Mapping;
import org.jimkast.ooj.map.MappingFork;
import org.jimkast.ooj.source.Target;
import org.jimkast.ooj.target.Ref;
import org.jimkast.ooj.target.RefQueue;

public interface Source<T> {
    <X> X feed(Mapping<T, X> target, X other);

    interface BiSource<X, Y> {
        <Z> Z feed(BiMapping<X, Y, Z> target, Z other);
    }

    final class Empty<T> implements Source<T> {
        private static final Source INSTANCE = new Empty<>();

        @Override
        public <X> X feed(Mapping<T, X> target, X other) {
            return other;
        }

        @SuppressWarnings("unchecked")
        public static <T> Source<T> instance() {
            return INSTANCE;
        }
    }

    final class Fixed<T> implements Source<T> {
        private final T val;

        public Fixed(T val) {
            this.val = val;
        }

        @Override
        public <X> X feed(Mapping<T, X> target, X other) {
            return target.map(val);
        }
    }


    final class Range implements Source<Integer> {
        private int i;
        private final int max;

        public Range(int i, int max) {
            this.i = i;
            this.max = max;
        }

        @Override
        public <X> X feed(Mapping<Integer, X> target, X other) {
            return i <= max ? target.map(i++) : other;
        }
    }


    final class Case<K, V> implements Mapping<K, Source<V>> {
        private final Check<K> chk;
        private final Source<V> value;

        public Case(Check<K> chk, V value) {
            this(chk, new Source.Fixed<>(value));
        }

        public Case(Check<K> chk, Source<V> value) {
            this.chk = chk;
            this.value = value;
        }

        @Override
        public Source<V> map(K key) {
            return chk.test(key).choose(value, Empty.instance());
        }
    }


    final class Any<K, V> implements Mapping<K, Source<V>> {
        private final Iterable<Mapping<K, Source<V>>> all;

        public Any(Iterable<Mapping<K, Source<V>>> all) {
            this.all = all;
        }

        @Override
        public Source<V> map(K key) {
            for (Mapping<K, Source<V>> mapping : all) {
                if (mapping.map(key).feed(new Fixed<>(true), false)) {
                    return mapping.map(key);
                }
            }
            return Empty.instance();
        }
    }


    final class Choose<K, V> implements Mapping<K, V> {
        private final V def;
        private final Mapping<K, Source<V>> cases;

        public Choose(V def, Mapping<K, Source<V>> cases) {
            this.def = def;
            this.cases = cases;
        }

        @Override
        public V map(K key) {
            return cases.map(key).feed(Mapping.Self.instance(), def);
        }
    }


    final class Mapped<T, W> implements Source<W> {
        private final Mapping<T, W> mapping;
        private final Source<T> origin;

        public Mapped(Mapping<T, W> mapping, Source<T> origin) {
            this.mapping = mapping;
            this.origin = origin;
        }

        @Override
        public <X> X feed(Mapping<W, X> target, X other) {
            return origin.feed(new MappedKey<>(mapping, target), other);
        }
    }

    final class Combined2<X, Y> implements BiSource<X, Y> {
        private final Mapping<X, Y> mapping;
        private final Source<X> s1;

        public Combined2(Mapping<X, Y> mapping, Source<X> s1) {
            this.mapping = mapping;
            this.s1 = s1;
        }

        @Override
        public <Z> Z feed(BiMapping<X, Y, Z> target, Z other) {
            return s1.feed(x -> target.map(x, mapping.map(x)), other);
        }
    }


    final class Combined<X, Y> implements BiSource<X, Y> {
        private final Source<X> s1;
        private final Source<Y> s2;

        public Combined(Source<X> s1, Source<Y> s2) {
            this.s1 = s1;
            this.s2 = s2;
        }

        @Override
        public <Z> Z feed(BiMapping<X, Y, Z> target, Z other) {
            return s1.feed(x -> s2.feed(y -> target.map(x, y), other), other);
        }
    }


    final class While<T> implements Source<T> {
        private final Check<T> check;
        private final Source<T> origin;

        public While(Check<T> check, Source<T> origin) {
            this.check = check;
            this.origin = origin;
        }

        @Override
        public <X> X feed(Mapping<T, X> target, X other) {
            return origin.feed(new MappingFork<>(check, target, new Mapping.Fixed<>(other)), other);
        }
    }


    final class Filtered<T> implements Source<T> {
        private final BiSource<T, Boolean> bi;

        public Filtered(Check<T> check, Source<T> origin) {
            this(new Combined2<>(key -> check.test(key).choose(true, false), origin));
        }

        public Filtered(BiSource<T, Boolean> bi) {
            this.bi = bi;
        }

        @Override
        public <X> X feed(Mapping<T, X> target, X other) {
            RefQueue<X> store = new RefQueue<>(other);
            while (bi.feed((t, cond) -> {
                if (cond) {
                    store.accept(target.map(t));
                }
                return !cond;
            }, false)) ;
            X x = store.length() == 0 ? other : store.map(0);
            store.feed(x1 -> {
            });
            return x;
        }
    }


    final class Flattened<T> implements Source<T> {
        private final Source<Source<T>> all;
        private final ArrayTarget<Source<T>> store = new Ref<>();

        public Flattened(Source<Source<T>> all) {
            this.all = all;
        }

        @Override
        public <X> X feed(Mapping<T, X> target, X other) {
            while (store.length() == 0 && all.feed(key -> {
                store.accept(key);
                return true;
            }, false)) {
                return store.map(0).feed(target, other);
            }
            return other;
        }
    }


    final class ForEach<T> implements org.jimkast.ooj.source.Source<T> {
        private final Source<T> origin;

        public ForEach(Source<T> origin) {
            this.origin = origin;
        }

        @Override
        public void feed(Target<T> target) {
            while (origin.feed(key -> {
                target.accept(key);
                return true;
            }, false)) ;
        }
    }

    final class Reduced<T> implements BiSource<T, T> {
        private final Source<T> origin;

        public Reduced(Source<T> origin) {
            this.origin = origin;
        }

        @Override
        public <Z> Z feed(BiMapping<T, T, Z> target, Z other) {
            return null;
        }
    }


    final class AsIterator<T> implements Iterator<T> {
        private final Source<T> s;
        private ArrayTarget<T> store = new RefQueue<>();
        private boolean fetched = false;


        public AsIterator(Source<T> s) {
            this.s = s;
        }

        @Override
        public boolean hasNext() {
            if (!fetched) {
                fetched = true;
                return s.feed(key -> {
                    store.accept(key);
                    return true;
                }, false);
            }
            return store.length() > 0;
        }

        @Override
        public T next() {
            if (hasNext()) {
                throw new NoSuchElementException();
            }
            return store.map(0);
        }
    }


    final class OfIterator<T> implements Source<T> {
        private final Iterator<T> iter;

        public OfIterator(Iterator<T> iter) {
            this.iter = iter;
        }

        @Override
        public <X> X feed(Mapping<T, X> target, X other) {
            return iter.hasNext() ? target.map(iter.next()) : other;
        }
    }
}
