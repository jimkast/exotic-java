package org.jimkast.ooj.source.adapter;

import java.util.Iterator;

public final class IteratorFixed<T> implements Iterator<T> {
    private final T item;

    public IteratorFixed(T item) {
        this.item = item;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public T next() {
        return item;
    }
}
