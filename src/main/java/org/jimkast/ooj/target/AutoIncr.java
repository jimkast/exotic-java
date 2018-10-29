package org.jimkast.ooj.target;

import org.jimkast.ooj.lang.Quantity;

public final class AutoIncr implements Quantity {
    private int i;

    public AutoIncr() {
        this(0);
    }

    public AutoIncr(int i) {
        this.i = i;
    }

    @Override
    public int length() {
        return i++;
    }
}
