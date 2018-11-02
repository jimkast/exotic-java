package org.jimkast.ooj.source;

public interface Target<T> {
    void accept(T t);

    Target<?> EMPTY = new Noop<>();

    final class Noop<T> implements Target<T> {
        @Override
        public void accept(T t) {
        }

        @SuppressWarnings("unchecked")
        public static <T> Target<T> instance() {
            return (Target<T>) EMPTY;
        }
    }


    final class Both<T> implements Target<T> {
        private final Target<T> t1;
        private final Target<T> t2;

        public Both(Target<T> t1, Target<T> t2) {
            this.t1 = t1;
            this.t2 = t2;
        }

        @Override
        public void accept(T t) {
            t1.accept(t);
            t2.accept(t);
        }
    }

    final class All<T> implements Target<T> {
        private final Source<Target<T>> all;

        public All(Target<T>... all) {
            this(new PsFlattened<>(new PsOfIterable<>(all)));
        }

        public All(Source<Target<T>> all) {
            this.all = all;
        }

        @Override
        public void accept(T t) {
            all.feed(target -> target.accept(t));
        }
    }
}
