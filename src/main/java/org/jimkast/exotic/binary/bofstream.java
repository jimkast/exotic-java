package org.jimkast.exotic.binary;

import org.jimkast.exotic.possible.possible;

public final class bofstream implements binary {
    private final Number length;
    private final possible<? extends Number> p;

    public bofstream(Number length, possible<? extends Number> p) {
        this.length = length;
        this.p = p;
    }

    @Override
    public int at(int i) {
        return 0;
    }

    @Override
    public int length() {
        return length.intValue();
    }
}
