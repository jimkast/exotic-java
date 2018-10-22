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
}
