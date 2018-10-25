package org.jimkast.ooj.map;

import org.jimkast.ooj.source.PsOrElse;
import org.jimkast.ooj.source.PSource;

public final class Choose<K, V> implements Mapping<K, V> {
    private final Mapping<PSource<V>, V> other;
    private final PMapping<K, V> possible;

    @SafeVarargs
    public Choose(V other, PMapping<K, V>... possible) {
        this(other, new Any<>(possible));
    }

    public Choose(V other, PMapping<K, V> possible) {
        this(new PsOrElse<>(other), possible);
    }

    public Choose(Mapping<PSource<V>, V> other, PMapping<K, V> possible) {
        this.other = other;
        this.possible = possible;
    }

    @Override
    public V map(K key) {
        return other.map(possible.map(key));
    }
}
