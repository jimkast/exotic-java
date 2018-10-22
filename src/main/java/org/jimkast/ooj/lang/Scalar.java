package org.jimkast.ooj.lang;

public interface Scalar<T> {
    T value();

    class Env<T> implements Scalar<T> {
        private final Scalar<T> origin;

        public Env(Scalar<T> origin) {
            this.origin = origin;
        }

        @Override
        public final T value() {
            return origin.value();
        }
    }
}
