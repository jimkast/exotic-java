package org.jimkast.ooj.bool.bi;

import java.util.Arrays;
import java.util.function.BiPredicate;

public final class Or<X, Y> implements BiPredicate<X, Y> {
    private final Iterable<BiPredicate<X, Y>> all;

    @SafeVarargs
    public Or(BiPredicate<X, Y>... all) {
        this(Arrays.asList(all));
    }

    public Or(Iterable<BiPredicate<X, Y>> all) {
        this.all = all;
    }

    @Override
    public boolean test(X x, Y y) {
        for (BiPredicate<X, Y> check : all) {
            if (check.test(x, y)) {
                return true;
            }
        }
        return false;
    }
}
