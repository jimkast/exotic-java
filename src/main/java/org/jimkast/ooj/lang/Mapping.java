package org.jimkast.ooj.lang;

public interface Mapping<K, T> {
    T map(K key);

    class Env<K, T> implements Mapping<K, T> {
        private final Mapping<K, T> origin;

        public Env(Mapping<K, T> origin) {
            this.origin = origin;
        }

        @Override
        public T map(K key) {
            return origin.map(key);
        }
    }

    final class Fixed<K, T> implements Mapping<K, T> {
        private final T value;

        public Fixed(T value) {
            this.value = value;
        }

        @Override
        public T map(K key) {
            return value;
        }
    }


    final class FixedScalar<K, T> implements Mapping<K, T> {
        private final Scalar<T> source;

        public FixedScalar(Scalar<T> source) {
            this.source = source;
        }

        @Override
        public T map(K key) {
            return source.value();
        }
    }
}
