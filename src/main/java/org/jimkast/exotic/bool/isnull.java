package org.jimkast.exotic.bool;

import org.jimkast.exotic.Native;

public final class isnull implements cond {
    private final Object o;

    public isnull(Object o) {
        this.o = o;
    }

    @Native
    @Override
    public <T> T choose(T left, T right) {
        return o == null ? left : right;
    }
}
