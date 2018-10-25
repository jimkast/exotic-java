package org.jimkast.ooj.map;

import org.jimkast.ooj.source.OrElse;

public final class Choose<K, V> implements Mapping<K, V> {
    private final V other;
    private final PMapping<K, V> possible;

    @SafeVarargs
    public Choose(V other, PMapping<K, V>... possible) {
        this(other, new Any<>(possible));
    }

    public Choose(V other, PMapping<K, V> possible) {
        this.other = other;
        this.possible = possible;
    }

    @Override
    public V map(K key) {
        return new OrElse<>(other, possible.map(key)).value();
    }
}
