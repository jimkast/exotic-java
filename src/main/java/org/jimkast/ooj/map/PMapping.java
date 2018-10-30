package org.jimkast.ooj.map;

import org.jimkast.ooj.source.Source;

public interface PMapping<K, V> extends Mapping<K, Source<V>> {

    class Env<K, V> implements PMapping<K, V> {
        private final PMapping<K, V> origin;

        public Env(PMapping<K, V> origin) {
            this.origin = origin;
        }

        @Override
        public final Source<V> map(K key) {
            return origin.map(key);
        }
    }

    final class OfMapping<K, V> implements PMapping<K, V> {
        private final Mapping<K, Source<V>> mapping;

        public OfMapping(Mapping<K, Source<V>> mapping) {
            this.mapping = mapping;
        }

        @Override
        public Source<V> map(K key) {
            return mapping.map(key);
        }
    }

    final class Fixed<K, V> extends Env<K, V> {
        public Fixed(V value) {
            super(new OfMapping<>(new Mapping.Fixed<>(new Source.Fixed<>(value))));
        }
    }
}
