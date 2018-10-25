package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Cond;

public final class PsStore<T> implements PSource<T> {
    private final Store<T> store;
    private final PSource<T> origin;

    public PsStore(PSource<T> origin) {
        this(new StoreQueue<>(), origin);
    }

    public PsStore(Store<T> store, PSource<T> origin) {
        this.store = store;
        this.origin = origin;
    }

    @Override
    public Cond feed(Target<T> target) {
        origin.feed(store);
        return store.feed(target);
    }
}
