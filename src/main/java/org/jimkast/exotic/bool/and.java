package org.jimkast.exotic.bool;

import java.util.function.Supplier;

public final class and implements bool {
    private final bool n1;
    private final bool n2;

    public and(bool n1, bool n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public <T> T choose(T left, T right) {
        return n1.choose((Supplier<T>) () -> left, () -> n2.choose(left, right)).get();
    }
}
