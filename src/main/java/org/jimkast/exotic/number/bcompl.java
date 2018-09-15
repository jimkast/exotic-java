package org.jimkast.exotic.number;

import org.jimkast.exotic.Native;

@Native
public final class bcompl extends Number {
    private final Number n1;

    public bcompl(Number n1) {
        this.n1 = n1;
    }

    @Override
    public int intValue() {
        return ~n1.intValue();
    }

    @Override
    public long longValue() {
        return ~n1.longValue();
    }

    @Override
    public float floatValue() {
        return Float.floatToRawIntBits(intValue());
    }

    @Override
    public double doubleValue() {
        return Double.longBitsToDouble(longValue());
    }
}
