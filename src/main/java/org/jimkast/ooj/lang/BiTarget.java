package org.jimkast.ooj.lang;

public interface BiTarget<X, Y> {
    void accept(X x, Y y);

    BiTarget EMPTY = new Noop<>();

    final class Noop<X, Y> implements BiTarget<X, Y> {
        @Override
        public void accept(X x, Y y) {
        }

        @SuppressWarnings("unchecked")
        public static <X, Y> BiTarget<X, Y> instance() {
            return (BiTarget<X, Y>) EMPTY;
        }
    }

}
