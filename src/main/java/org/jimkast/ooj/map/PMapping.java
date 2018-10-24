package org.jimkast.ooj.map;

import org.jimkast.ooj.lang.Mapping;
import org.jimkast.ooj.lang.PSource;

public interface PMapping<K, V> extends Mapping<K, PSource<V>> {

    class Env<K, V> implements PMapping<K, V> {
        private final PMapping<K, V> origin;

        public Env(PMapping<K, V> origin) {
            this.origin = origin;
        }

        @Override
        public final PSource<V> map(K key) {
            return origin.map(key);
        }
    }

    final class OfMapping<K, V> implements PMapping<K, V> {
        private final Mapping<K, PSource<V>> mapping;

        public OfMapping(Mapping<K, PSource<V>> mapping) {
            this.mapping = mapping;
        }

        @Override
        public PSource<V> map(K key) {
            return mapping.map(key);
        }
    }
}
