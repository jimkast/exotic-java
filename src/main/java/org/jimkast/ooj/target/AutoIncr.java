package org.jimkast.ooj.target;

import org.jimkast.exotic.numberjdk.Int;

public final class AutoIncr extends Int {
    private int i;

    public AutoIncr() {
        this(0);
    }

    public AutoIncr(int i) {
        this.i = i;
    }

    @Override
    public int intValue() {
        return i++;
    }
}
