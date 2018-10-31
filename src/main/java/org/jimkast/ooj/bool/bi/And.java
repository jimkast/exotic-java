package org.jimkast.ooj.bool.bi;

import java.util.Arrays;
import java.util.function.BiPredicate;

public final class And<X, Y> implements BiPredicate<X, Y> {
    private final Iterable<BiPredicate<X, Y>> all;

    @SafeVarargs
    public And(BiPredicate<X, Y>... all) {
        this(Arrays.asList(all));
    }

    public And(Iterable<BiPredicate<X, Y>> all) {
        this.all = all;
    }

    @Override
    public boolean test(X x, Y y) {
        for (BiPredicate<X, Y> check : all) {
            if (!check.test(x, y)) {
                return false;
            }
        }
        return true;
    }
}
