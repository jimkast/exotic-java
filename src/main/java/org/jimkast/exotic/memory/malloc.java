package org.jimkast.exotic.memory;

import org.jimkast.exotic.Native;

@Native
public final class malloc implements memblockRW {
    private final byte[] arr;

    public malloc(int length) {
        this(new byte[length]);
    }

    private malloc(byte[] arr) {
        this.arr = arr;
    }

    public Number at(Number pos) {
        return arr[pos.intValue()];
    }

    @Override
    public void write(Number pos, Number value) {
        arr[pos.intValue()] = value.byteValue();
    }

    @Override
    public void writeFrom(Number srcOff, memblockR a, Number destOff, Number length) {
        System.arraycopy(a.address().arr, srcOff.intValue(), arr, destOff.intValue(), length.intValue());
    }

    @Override
    public Number length() {
        return arr.length;
    }

    @Override
    public addr address() {
        return new addr(arr);
    }
}
