package org.jimkast.ooj.bisource;

import org.jimkast.ooj.cond.Cond;

public interface BiPSource<X,Y> {
    Cond feed(BiTarget<X,Y> target);


    class Env<X,Y> implements BiPSource<X,Y> {
        private final BiPSource<X,Y> origin;

        public Env(BiPSource<X,Y> origin) {
            this.origin = origin;
        }

        @Override
        public final Cond feed(BiTarget<X,Y> target) {
            return origin.feed(target);
        }
    }


    final class Empty<X,Y> implements BiPSource<X,Y> {
        private static final BiPSource EMPTY = new Empty<>();

        @Override
        public Cond feed(BiTarget<X,Y> target) {
            return Cond.FALSE;
        }

        @SuppressWarnings("unchecked")
        public static <X,Y> BiPSource<X,Y> instance() {
            return (BiPSource<X,Y>) EMPTY;
        }
    }
}
