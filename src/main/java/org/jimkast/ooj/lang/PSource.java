package org.jimkast.ooj.lang;

public interface PSource<T> {
    Cond feed(Target<T> target);


    class Env<T> implements PSource<T> {
        private final PSource<T> origin;

        public Env(PSource<T> origin) {
            this.origin = origin;
        }

        @Override
        public final Cond feed(Target<T> target) {
            return origin.feed(target);
        }
    }


    final class Empty<T> implements PSource<T> {
        private static final PSource<?> EMPTY = new Empty<>();

        @Override
        public Cond feed(Target<T> target) {
            return Cond.FALSE;
        }

        @SuppressWarnings("unchecked")
        public static <T> PSource<T> instance() {
            return (PSource<T>) EMPTY;
        }
    }


    final class Fixed<T> implements PSource<T> {
        private final T t;

        public Fixed(T t) {
            this.t = t;
        }

        @Override
        public Cond feed(Target<T> target) {
            target.accept(t);
            return Cond.TRUE;
        }
    }
}
