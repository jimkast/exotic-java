package org.jimkast.exotic.bool;

import java.util.function.Supplier;

public final class and implements cond {
    private final cond n1;
    private final cond n2;

    public and(cond n1, cond n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public <T> T choose(T left, T right) {
        return n1.choose((Supplier<T>) () -> left, () -> n2.choose(left, right)).get();
    }
}
