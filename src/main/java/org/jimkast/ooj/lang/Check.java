package org.jimkast.ooj.lang;

public interface Check<T> {
    Cond test(T t);

    final class Not<T> implements Check<T> {
        private final Check<T> origin;

        public Not(Check<T> origin) {
            this.origin = origin;
        }

        @Override
        public Cond test(T t) {
            return origin.test(t).choose(Cond.FALSE, Cond.TRUE);
        }
    }


    final class Eq<T> implements Check<T> {
        private final T against;

        public Eq(T against) {
            this.against = against;
        }

        @Override
        public Cond test(T t) {
            return against == t ? Cond.TRUE : Cond.FALSE;
        }
    }
}
