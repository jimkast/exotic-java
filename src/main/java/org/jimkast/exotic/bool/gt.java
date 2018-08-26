package org.jimkast.exotic.bool;

import org.jimkast.exotic.Native;

public final class gt implements cond {
    private final Number n1;
    private final Number n2;

    public gt(Number n1, Number n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Native
    @Override
    public <T> T choose(T left, T right) {
        return n1.doubleValue() > n2.doubleValue() ? left : right;
    }
}
