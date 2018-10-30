package org.jimkast.ooj.bisource;

import org.jimkast.ooj.source.Target;

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


    final class Both<X, Y> implements BiTarget<X, Y> {
        private final BiTarget<X, Y> t1;
        private final BiTarget<X, Y> t2;

        public Both(BiTarget<X, Y> t1, BiTarget<X, Y> t2) {
            this.t1 = t1;
            this.t2 = t2;
        }

        @Override
        public void accept(X x, Y y) {
            t1.accept(x, y);
            t2.accept(x, y);
        }
    }

    final class Split<X, Y> implements BiTarget<X, Y> {
        private final Target<X> t1;
        private final Target<Y> t2;

        public Split(Target<X> t1, Target<Y> t2) {
            this.t1 = t1;
            this.t2 = t2;
        }

        @Override
        public void accept(X x, Y y) {
            t1.accept(x);
            t2.accept(y);
        }
    }

    final class Ignore1<X, Y> implements BiTarget<X, Y> {
        private final Target<Y> target;

        public Ignore1(Target<Y> target) {
            this.target = target;
        }

        @Override
        public void accept(X x, Y y) {
            target.accept(y);
        }
    }


    final class Ignore2<X, Y> implements BiTarget<X, Y> {
        private final Target<X> target;

        public Ignore2(Target<X> target) {
            this.target = target;
        }

        @Override
        public void accept(X x, Y y) {
            target.accept(x);
        }
    }

}
