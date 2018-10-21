package org.jimkast.exotic.heap;

public final class HeapFixed implements HeapBlock {
    private final HeapAddr pointer;
    private final Number length;

    public HeapFixed(byte[] jarr) {
        this(new HeapAddr(jarr), jarr.length);
    }

    public HeapFixed(byte[] jarr, int offset, Number length) {
        this(new HeapAddr(jarr, offset), length);
    }

    public HeapFixed(HeapAddr pointer, Number length) {
        this.pointer = pointer;
        this.length = length;
    }

    @Override
    public HeapAddr address() {
        return pointer;
    }

    @Override
    public int length() {
        return length.intValue();
    }
}
