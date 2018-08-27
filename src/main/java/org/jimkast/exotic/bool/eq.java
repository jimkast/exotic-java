package org.jimkast.exotic.bool;

import org.jimkast.exotic.Native;

public final class eq implements bool {
    private final Object n1;
    private final Object n2;

    public eq(Object n1, Object n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Native
    @Override
    public <T> T choose(T left, T right) {
//        return n1.equals(n2) ? left : right;
        return n1 == n2 ? left : right;
    }
}
