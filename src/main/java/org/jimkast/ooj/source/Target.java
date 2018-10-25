package org.jimkast.ooj.source;

public interface Target<T> {
    void accept(T t);

    Target<?> EMPTY = new Noop<>();

    final class Noop<T> implements Target<T> {
        @Override
        public void accept(T t) {
        }

        @SuppressWarnings("unchecked")
        public static <T> Target<T> instance() {
            return (Target<T>) EMPTY;
        }
    }

}
