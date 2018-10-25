package org.jimkast.ooj.map;

public final class MappedKey<X, Y, V> implements Mapping<Y, V> {
    private final Mapping<Y, X> mapper;
    private final Mapping<X, V> origin;

    public MappedKey(Mapping<Y, X> mapper, Mapping<X, V> origin) {
        this.mapper = mapper;
        this.origin = origin;
    }

    @Override
    public V map(Y key) {
        return origin.map(mapper.map(key));
    }
}
