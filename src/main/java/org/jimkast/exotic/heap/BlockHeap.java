package org.jimkast.exotic.heap;

public final class BlockHeap {
    private final byte[] b;
    private final int offset;
    private final int length;

    public BlockHeap(byte[] b, int offset, int length) {
        this.b = b;
        this.offset = offset;
        this.length = length;
    }
}
