package org.jimkast.ooj.source;

public interface Store<T> extends Target<T>, Source<T> {

    class Env<T> implements Store<T> {
        private final Store<T> origin;

        public Env(Store<T> origin) {
            this.origin = origin;
        }

        @Override
        public void accept(T t) {
            origin.accept(t);
        }

        @Override
        public void feed(Target<T> target) {
            origin.feed(target);
        }
    }

    final class DecSource<T> implements Store<T> {
        private final Source<T> dec;
        private final Store<T> origin;

        public DecSource(Source<T> dec, Store<T> origin) {
            this.dec = dec;
            this.origin = origin;
        }

        @Override
        public void accept(T t) {
            origin.accept(t);
        }

        @Override
        public void feed(Target<T> target) {
            dec.feed(target);
        }
    }


    final class DecTarget<T> implements Store<T> {
        private final Target<T> dec;
        private final Store<T> origin;

        public DecTarget(Target<T> dec, Store<T> origin) {
            this.dec = dec;
            this.origin = origin;
        }


        @Override
        public void accept(T t) {
            dec.accept(t);
        }

        @Override
        public void feed(Target<T> target) {
            origin.feed(target);
        }
    }
}
