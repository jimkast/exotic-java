package org.jimkast.ooj.source;

import org.jimkast.ooj.lang.Scalar;
import org.jimkast.ooj.lang.Source;
import org.jimkast.ooj.lang.Store;

public final class ScalarSource<T> implements Scalar<T> {
    private final Source<T> source;
    private final Store<T> store;

    public ScalarSource(Source<T> source) {
        this(source, new Store.StoreList<>());
    }

    public ScalarSource(Source<T> source, Store<T> store) {
        this.source = source;
        this.store = store;
    }

    @Override
    public T value() {
        source.feed(store);
        return store.value();
    }
}
