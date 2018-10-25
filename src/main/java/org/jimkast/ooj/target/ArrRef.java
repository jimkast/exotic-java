package org.jimkast.ooj.target;

import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.source.Store;
import org.jimkast.ooj.source.Target;

public final class ArrRef<T> implements Store<T> {
    private final ObjectArray<T> arr;
    private final Number offset;

    public ArrRef(ObjectArray<T> arr, Number offset) {
        this.arr = arr;
        this.offset = offset;
    }

    @Override
    public Cond feed(Target<T> target) {
        return arr.map(offset.intValue()).feed(target);
    }

    @Override
    public void accept(T t) {
        arr.accept(offset.intValue(), t);
    }
}
