package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;

public final class simple implements binary {
    private final int[] arr;

    public simple(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int at(int i) {
        return arr[i];
    }

    @Override
    public int length() {
        return arr.length;
    }
}
