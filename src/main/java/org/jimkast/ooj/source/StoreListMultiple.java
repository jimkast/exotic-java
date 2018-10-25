package org.jimkast.ooj.source;

import java.util.LinkedList;
import java.util.List;

public final class StoreListMultiple<T> implements Target<T>, SourceStream<T> {
    private final List<T> list;

    public StoreListMultiple() {
        this(new LinkedList<>());
    }

    public StoreListMultiple(List<T> list) {
        this.list = list;
    }

    @Override
    public void accept(T t) {
        list.add(t);
    }

    @Override
    public PSource<T> stream() {
        return new PsOfIterator<>(list.iterator());
    }
}
