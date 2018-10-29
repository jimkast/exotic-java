package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;

public final class fixed32 implements binary {
    private final int[] arr;

    public fixed32(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int map(int i) {
        return arr[i];
    }

    @Override
    public int length() {
        return arr.length;
    }
}
