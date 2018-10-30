package org.jimkast.ooj.source;

import org.jimkast.ooj.target.RefQueue;

public final class PsStore<T> implements Source<T> {
    private final Store<T> store;
    private final Source<T> origin;

    public PsStore(Source<T> origin) {
        this(new RefQueue<>(), origin);
    }

    public PsStore(Store<T> store, Source<T> origin) {
        this.store = store;
        this.origin = origin;
    }

    @Override
    public void feed(Target<T> target) {
        origin.feed(store);
        store.feed(target);
    }
}
