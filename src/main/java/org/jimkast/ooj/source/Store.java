package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Cond;

public interface Store<T> extends Target<T>, PSource<T> {

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
        public Cond feed(Target<T> target) {
            return origin.feed(target);
        }
    }

    final class DecSource<T> implements Store<T> {
        private final PSource<T> dec;
        private final Store<T> origin;

        public DecSource(PSource<T> dec, Store<T> origin) {
            this.dec = dec;
            this.origin = origin;
        }

        @Override
        public void accept(T t) {
            origin.accept(t);
        }

        @Override
        public Cond feed(Target<T> target) {
            return dec.feed(target);
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
        public Cond feed(Target<T> target) {
            return origin.feed(target);
        }
    }
}
