package org.jimkast.ooj.lang;

import java.util.Arrays;
import org.jimkast.ooj.source.OrElse;
import org.jimkast.ooj.source.PsFlattened;
import org.jimkast.ooj.source.PsMapped;
import org.jimkast.ooj.source.PsOfIterator;

public interface PMapping<K, V> extends Mapping<K, PSource<V>> {

    class Env<K, V> implements PMapping<K, V> {
        private final PMapping<K, V> origin;

        public Env(PMapping<K, V> origin) {
            this.origin = origin;
        }

        @Override
        public final PSource<V> map(K key) {
            return origin.map(key);
        }
    }


    final class OfMapping<K, V> implements PMapping<K, V> {
        private final Mapping<K, PSource<V>> mapping;

        public OfMapping(Mapping<K, PSource<V>> mapping) {
            this.mapping = mapping;
        }

        @Override
        public PSource<V> map(K key) {
            return mapping.map(key);
        }
    }


    final class Fixed<K, V> extends Env<K, V> {
        public Fixed(V value) {
            super(new OfMapping<>(new PMapping.Fixed<>(value)));
        }
    }


    final class Simple<K, V> extends Env<K, V> {
        public Simple(Check<K> check, V value) {
            super(new OfMapping<>(new MappingCond<>(check, new PSource.Fixed<>(value), PSource.Empty.instance())));
        }
    }


    final class Any<K, V> implements PMapping<K, V> {
        private final PSource<PMapping<K, V>> all;

        @SafeVarargs
        public Any(PMapping<K, V>... all) {
            this(new PsOfIterator<>(Arrays.asList(all).iterator()));
        }

        public Any(PSource<PMapping<K, V>> all) {
            this.all = all;
        }

        @Override
        public PSource<V> map(K key) {
            return new PsFlattened<>(
                new PsMapped<>(
                    p -> p.map(key),
                    all
                )
            );
        }
    }


    final class AsMapping<K, V> implements Mapping<K, V> {
        private final V other;
        private final PMapping<K, V> possible;

        @SafeVarargs
        public AsMapping(V other, PMapping<K, V>... possible) {
            this(other, new Any<>(possible));
        }

        public AsMapping(V other, PMapping<K, V> possible) {
            this.other = other;
            this.possible = possible;
        }

        @Override
        public V map(K key) {
            return new OrElse<>(other, possible.map(key)).value();
        }
    }
}
