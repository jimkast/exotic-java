package org.jimkast.ooj.map;

import org.jimkast.ooj.source.Scalar;

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


    final class Self<T> implements Mapping<T, T> {
        private static final Mapping SELF = new Self<>();

        @Override
        public T map(T key) {
            return key;
        }

        @SuppressWarnings("unchecked")
        public static <T> Mapping<T, T> instance() {
            return SELF;
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
