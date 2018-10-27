package org.jimkast.ooj.target;


import org.jimkast.ooj.source.PSource;
import org.jimkast.ooj.source.PsMapped;
import org.jimkast.ooj.source.PsRange;
import org.jimkast.ooj.source.SourceStream;

public final class ArrayStream<T> implements SourceStream<T> {
    private final ObjectArray<T> arr;

    public ArrayStream(ObjectArray<T> arr) {
        this.arr = arr;
    }

    @Override
    public PSource<T> stream() {
        return new PsMapped<>(
            arr::map,
            new PsRange(arr.length())
        );
    }
}
