package org.jimkast.exotic.heap;

import sun.misc.Unsafe;

public final class BlockDirect {
    private final long addr;
    private final long length;

    public BlockDirect(long length) {
        this.addr = Unsafe.getUnsafe().allocateMemory(length);
        this.length = length;
    }
}
