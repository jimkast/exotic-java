package org.jimkast.exotic.string;

public final class BlockDirect {
    private final long addr;
    private final long length;

    public BlockDirect(long addr, long length) {
        this.addr = addr;
        this.length = length;
    }
}
