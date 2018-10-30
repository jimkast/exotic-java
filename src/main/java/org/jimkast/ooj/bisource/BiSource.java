package org.jimkast.ooj.bisource;

public interface BiSource<X,Y> {
    void feed(BiTarget<X,Y> target);


    class Env<X,Y> implements BiSource<X,Y> {
        private final BiSource<X,Y> origin;

        public Env(BiSource<X,Y> origin) {
            this.origin = origin;
        }

        @Override
        public final void feed(BiTarget<X,Y> target) {
            origin.feed(target);
        }
    }


    final class Empty<X,Y> implements BiSource<X,Y> {
        private static final BiSource EMPTY = new Empty<>();

        @Override
        public void feed(BiTarget<X,Y> target) {
        }

        @SuppressWarnings("unchecked")
        public static <X,Y> BiSource<X,Y> instance() {
            return (BiSource<X,Y>) EMPTY;
        }
    }
}
