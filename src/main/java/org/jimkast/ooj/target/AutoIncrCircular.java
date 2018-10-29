package org.jimkast.ooj.target;

import org.jimkast.ooj.lang.Quantity;

public final class AutoIncrCircular implements Quantity {
    private final Quantity size;
    private int i;

    public AutoIncrCircular(Quantity size) {
        this(size, 0);
    }

    public AutoIncrCircular(Quantity size, int i) {
        this.size = size;
        this.i = i;
    }

    @Override
    public int length() {
        int temp = i;
        i = (i + 1) % size.length();
        return temp;
    }
}
