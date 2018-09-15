package org.jimkast.exotic.number;

import org.jimkast.exotic.Native;

@Native
public final class bor extends Number {
    private final Number n1;
    private final Number n2;

    public bor(Number n1, Number n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public int intValue() {
        return n1.intValue() | n2.intValue();
    }

    @Override
    public long longValue() {
        return n1.longValue() | n2.longValue();
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
