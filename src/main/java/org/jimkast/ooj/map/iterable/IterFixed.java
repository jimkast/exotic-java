package org.jimkast.ooj.map.iterable;

import java.util.Iterator;

public final class IterFixed<T> implements Iterator<T> {
    private final T item;

    public IterFixed(T item) {
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
