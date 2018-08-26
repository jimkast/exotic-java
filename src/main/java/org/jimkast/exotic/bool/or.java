package org.jimkast.exotic.bool;

import java.util.function.Supplier;

public final class or implements cond {
    private final cond n1;
    private final cond n2;

    public or(cond n1, cond n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public <T> T choose(T left, T right) {
        return n1.choose(() -> n2.choose(left, right), (Supplier<T>) () -> right).get();
    }
}
