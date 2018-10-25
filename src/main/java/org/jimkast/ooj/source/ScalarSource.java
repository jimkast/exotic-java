package org.jimkast.ooj.source;

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
