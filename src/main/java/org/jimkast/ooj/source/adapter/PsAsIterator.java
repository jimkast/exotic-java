package org.jimkast.ooj.source.adapter;

import java.util.Iterator;
import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.source.Source;
import org.jimkast.ooj.target.RefQueue;

public final class PsAsIterator<T> implements Iterator<T> {
    private final Source<T> source;
    private final ArrayTarget<T> store = new RefQueue<>();
    private boolean fetched = false;

    public PsAsIterator(Source<T> source) {
        this.source = source;
    }

    @Override
    public boolean hasNext() {
        if (!fetched) {
            source.feed(store);
            fetched = true;
        }
        return store.length() > 0;
    }

    @Override
    public T next() {
        if (!fetched) {
            fetched = true;
            source.feed(store);
        }
        return store.map(0);
    }
}
