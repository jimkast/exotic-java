package org.jimkast.ooj.cond;

public interface BiCheckl<X, Y> {
    Cond test(X x, Y y);


    BiCheckl BiTRUE = (o, o2) -> Cond.TRUE;
    BiCheckl BiFALSE = (o, o2) -> Cond.FALSE;

    final class Ignored1<X, Y> implements BiCheckl<X, Y> {
        private final Check<Y> check;

        public Ignored1(Check<Y> check) {
            this.check = check;
        }

        @Override
        public Cond test(X x, Y y) {
            return check.test(y);
        }
    }


    final class Ignored2<X, Y> implements BiCheckl<X, Y> {
        private final Check<X> check;

        public Ignored2(Check<X> check) {
            this.check = check;
        }

        @Override
        public Cond test(X x, Y y) {
            return check.test(x);
        }
    }
}
