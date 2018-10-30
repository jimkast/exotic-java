package org.jimkast.ooj.source;

public interface Source<T> {
    void feed(Target<T> target);


    class Env<T> implements Source<T> {
        private final Source<T> origin;

        public Env(Source<T> origin) {
            this.origin = origin;
        }

        @Override
        public final void feed(Target<T> target) {
            origin.feed(target);
        }
    }


    final class Empty<T> implements Source<T> {
        private static final Source<?> EMPTY = new Empty<>();

        @Override
        public void feed(Target<T> target) {
        }

        @SuppressWarnings("unchecked")
        public static <T> Source<T> instance() {
            return (Source<T>) EMPTY;
        }
    }


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
