package org.jimkast.ooj.lang;

public interface Source<T> {
    void feed(Target<T> target);

    final class Fixed<T> implements Source<T> {
        private final T t;

        public Fixed(T t) {
            this.t = t;
        }

        @Override
        public void feed(Target<T> target) {
            target.accept(t);
        }
    }
}
