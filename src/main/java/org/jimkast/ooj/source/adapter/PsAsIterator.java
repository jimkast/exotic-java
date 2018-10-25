package org.jimkast.ooj.source.adapter;

import java.util.Iterator;
import org.jimkast.ooj.source.PSource;
import org.jimkast.ooj.source.StoreQueue;

public final class PsAsIterator<T> implements Iterator<T> {
    private final PSource<T> source;
    private final StoreQueue<T> store = new StoreQueue<>();
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
        return store.hasNext();
    }

    @Override
    public T next() {
        return store.next();
    }
}
