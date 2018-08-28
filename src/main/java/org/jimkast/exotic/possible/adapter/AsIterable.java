package org.jimkast.exotic.possible.adapter;

import java.util.Iterator;
import org.jimkast.exotic.possible.possible;

public final class AsIterable<T> implements Iterable<T>{
    private final possible<T> possible;

    public AsIterable(possible<T> possible) {
        this.possible = possible;
    }

    @Override
    public Iterator<T> iterator() {
        return new AsIterator<>(possible);
    }
}
