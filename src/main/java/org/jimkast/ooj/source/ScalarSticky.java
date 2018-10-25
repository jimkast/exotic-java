package org.jimkast.ooj.source;

import org.jimkast.ooj.map.Mapping;

public final class ScalarSticky<T> implements Scalar<T> {
    private final Mapping<T, T> store;
    private final Scalar<T> origin;

    public ScalarSticky(Scalar<T> origin) {
        this(new StoreSticky<>(), origin);
    }

    public ScalarSticky(Mapping<T, T> store, Scalar<T> origin) {
        this.store = store;
        this.origin = origin;
    }

    @Override
    public T value() {
        return store.map(origin.value());
    }
}
