package org.jimkast.exotic.memory;

import org.jimkast.exotic.Native;

@Native
public final class malloc implements memblockRW {
    private final byte[] arr;
    private final addr a;

    public malloc(int length) {
        this(new byte[length]);
    }

    malloc(byte[] arr) {
        this.arr = arr;
        this.a = new addr(arr);
    }

    @Override
    public Number at(Number pos) {
        return arr[pos.intValue()];
    }

    @Override
    public void write(Number pos, Number value) {
        arr[pos.intValue()] = value.byteValue();
    }

    public void writeTo(memblockR block) {
        addr a = block.address();
        System.arraycopy(a.arr, a.offset, a.arr, a.offset, block.length().intValue());
    }

    @Override
    public Number length() {
        return arr.length;
    }

    @Override
    public addr address() {
        return a;
    }
}
