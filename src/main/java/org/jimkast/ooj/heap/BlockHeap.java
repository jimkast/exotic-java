package org.jimkast.ooj.heap;

public final class BlockHeap {
    private final byte[] b;
    private final int offset;
    private final int length;

    public BlockHeap(int size) {
        this(new byte[size]);
    }

    public BlockHeap(byte[] b) {
        this(b, 0);
    }

    public BlockHeap(byte[] b, int offset) {
        this(b, offset, b.length - offset);
    }

    public BlockHeap(byte[] b, int offset, int length) {
        this.b = b;
        this.offset = offset;
        this.length = length;
    }
}
