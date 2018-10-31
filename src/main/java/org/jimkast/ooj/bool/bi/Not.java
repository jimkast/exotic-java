package org.jimkast.ooj.bool.bi;

import java.util.function.BiPredicate;

public final class Not<X, Y> implements BiPredicate<X, Y> {
    private final BiPredicate<X, Y> origin;

    public Not(BiPredicate<X, Y> origin) {
        this.origin = origin;
    }

    @Override
    public boolean test(X x, Y y) {
        return !origin.test(x, y);
    }
}
