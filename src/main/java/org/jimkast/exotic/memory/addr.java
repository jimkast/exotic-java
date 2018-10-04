package org.jimkast.exotic.memory;

import org.jimkast.exotic.Native;

@Native
public final class addr {
    final byte[] arr;

    addr(byte[] arr) {
        this.arr = arr;
    }
}
