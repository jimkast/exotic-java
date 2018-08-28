package org.jimkast.exotic.possible.adapter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;
import org.jimkast.exotic.possible.possible;

public final class AsIterator<T> implements Iterator<T>, Consumer<T> {
    private final possible<T> possible;
    private transient Queue<T> store = new LinkedList<>();

    public AsIterator(possible<T> possible) {
        this.possible = possible;
    }

    @Override
    public boolean hasNext() {
        possible.supply(this);
        return !store.isEmpty();
    }

    @Override
    public T next() {
        return store.poll();
    }

    @Override
    public void accept(T t) {
        store.add(t);
    }
}
