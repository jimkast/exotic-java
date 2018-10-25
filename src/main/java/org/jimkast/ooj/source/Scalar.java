package org.jimkast.ooj.source;

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


    final class Fixed<T> implements Scalar<T> {
        private final T val;

        public Fixed(T val) {
            this.val = val;
        }

        @Override
        public T value() {
            return val;
        }
    }
}
