package org.jimkast.exotic.possible.adapter;

import java.util.Arrays;
import java.util.Iterator;
import org.cactoos.scalar.StickyScalar;
import org.cactoos.scalar.UncheckedScalar;
import org.jimkast.exotic.possible.possible;

public final class iterable<T> extends possible.env<T> {
    @SafeVarargs
    public iterable(T... items) {
        this(Arrays.asList(items));
    }

    public iterable(Iterable<T> iterable) {
        super(new iterator<>(new IterableAsIterator<>(iterable)));
    }

    public static class IterableAsIterator<T> implements Iterator<T> {
        private final UncheckedScalar<Iterator<T>> scalar;

        public IterableAsIterator(Iterable<T> iterable) {
            this.scalar = new UncheckedScalar<>(new StickyScalar<>(iterable::iterator));
        }

        @Override
        public boolean hasNext() {
            return scalar.value().hasNext();
        }

        @Override
        public T next() {
            return scalar.value().next();
        }
    }
}
