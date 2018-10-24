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

    final class MappingCond<K, T> implements Mapping<K, T> {
        private final Check<K> check;
        private final T main;
        private final T other;

        public MappingCond(Check<K> check, T main, T other) {
            this.check = check;
            this.main = main;
            this.other = other;
        }

        @Override
        public T map(K key) {
            return check.test(key).choose(main, other);
        }
    }
}
