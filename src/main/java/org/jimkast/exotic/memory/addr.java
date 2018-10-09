package org.jimkast.exotic.memory;

import org.jimkast.exotic.Native;

@Native
public final class addr {
    final byte[] arr;
    final int offset;

    addr(byte[] arr) {
        this(arr, 0);
    }

    public addr(byte[] arr, int offset) {
        this.arr = arr;
        this.offset = offset;
    }
}
