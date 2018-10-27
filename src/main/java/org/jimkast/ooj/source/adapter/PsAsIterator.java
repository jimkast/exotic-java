package org.jimkast.ooj.source.adapter;

import java.util.Iterator;
import org.jimkast.ooj.source.PSource;
import org.jimkast.ooj.target.RefQueue;

public final class PsAsIterator<T> implements Iterator<T> {
    private final PSource<T> source;
    private final RefQueue<T> store = new RefQueue<>();
    private boolean fetched = false;

    public PsAsIterator(PSource<T> source) {
        this.source = source;
    }

    @Override
    public boolean hasNext() {
        if (!fetched) {
            source.feed(store);
            fetched = true;
        }
        return store.feed(store).choose(true, false);
    }

    @Override
    public T next() {
        if (!fetched) {
            fetched = true;
            source.feed(store);
        }
        return store.value();
    }
}
