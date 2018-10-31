package org.jimkast.ooj.source;


import org.jimkast.ooj.lang.Array;
import org.jimkast.ooj.target.ObjectArray;

public final class PsOfArray<T> extends Source.Env<T> {
    @SafeVarargs
    public PsOfArray(T... all) {
        this(new ObjectArray.Native<>(all));
    }

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
