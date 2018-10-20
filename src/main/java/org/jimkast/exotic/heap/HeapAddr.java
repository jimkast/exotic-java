package org.jimkast.exotic.heap;

import org.jimkast.exotic.Native;

@Native
public final class HeapAddr {
    final byte[] jarr;
    final int offset;

    HeapAddr(byte[] jarr) {
        this(jarr, 0);
    }

    public HeapAddr(byte[] jarr, int offset) {
        this.jarr = jarr;
        this.offset = offset;
    }
}
