package org.jimkast.ooj.map.iterable;

import java.util.Iterator;
import org.jimkast.ooj.map.Mapping;

public final class CaseMapped<K, X, Y> implements Mapping<K, Iterator<Y>> {
    private final Mapping<X, Y> mapping;
    private final Mapping<K, Iterator<X>> origin;

    public CaseMapped(Mapping<X, Y> mapping, Mapping<K, Iterator<X>> origin) {
        this.mapping = mapping;
        this.origin = origin;
    }

    @Override
    public Iterator<Y> map(K key) {
        return new org.cactoos.iterator.Mapped<>(mapping::map, origin.map(key));
    }
}
