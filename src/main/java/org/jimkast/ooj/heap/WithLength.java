package org.jimkast.ooj.heap;

import org.jimkast.ooj.lang.Quantity;

public final class WithLength implements Quantity {
    private final int length;

    public WithLength(int length) {
        this.length = length;
    }

    @Override
    public int length() {
        return length;
    }
}
