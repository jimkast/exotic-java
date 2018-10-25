package org.jimkast.ooj.target;

import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.source.Store;
import org.jimkast.ooj.source.Target;

public final class Fifo<T> implements Store<T> {
    private final T[] arr;
    private int first = 0;
    private int next = 0;

    public Fifo(int size) {
        this((T[]) new Object[size]);
    }

    public Fifo(T[] arr) {
        this.arr = arr;
    }

    @Override
    public Cond feed(Target<T> target) {
        T val = arr[first];
        if (val == null) {
            return Cond.FALSE;
        }
        target.accept(val);
        first = (first + 1) % arr.length;
        return Cond.TRUE;
    }

    @Override
    public void accept(T t) {
        arr[next] = t;
        next = (next + 1) % arr.length;
    }
}
