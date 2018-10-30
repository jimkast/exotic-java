package org.jimkast.ooj.source;


import org.jimkast.ooj.lang.Array;

public final class PsOfArray<T> extends Source.Env<T> {
    public PsOfArray(Array<T> array) {
        this(0, array);
    }

    public PsOfArray(int start, Array<T> array) {
        super(new PsMapped<>(
            array::map,
            new PsRange(start, array)
        ));
    }
}
