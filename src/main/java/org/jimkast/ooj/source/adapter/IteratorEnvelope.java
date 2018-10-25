package org.jimkast.ooj.source.adapter;

import java.util.Iterator;

public final class IteratorEnvelope<T> implements Iterator<T> {
    private final Iterator<T> origin;

    public IteratorEnvelope(Iterator<T> origin) {
        this.origin = origin;
    }

    @Override
    public boolean hasNext() {
        return origin.hasNext();
    }

    @Override
    public T next() {
        return origin.next();
    }
}
