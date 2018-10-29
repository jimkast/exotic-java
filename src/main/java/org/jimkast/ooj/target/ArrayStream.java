package org.jimkast.ooj.target;


import org.jimkast.ooj.lang.Array;
import org.jimkast.ooj.source.PSource;
import org.jimkast.ooj.source.PsOfArray;
import org.jimkast.ooj.source.SourceStream;

public final class ArrayStream<T> implements SourceStream<T> {
    private final Array<T> arr;

    public ArrayStream(Array<T> arr) {
        this.arr = arr;
    }

    @Override
    public PSource<T> stream() {
        return new PsOfArray<>(arr);
    }
}
