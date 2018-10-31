package org.jimkast.ooj.bool.bi;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public final class BiFor1<X, Y> implements BiPredicate<X, Y> {
    private final Predicate<? super X> single;

    public BiFor1(Predicate<? super X> single) {
        this.single = single;
    }

    @Override
    public boolean test(X x, Y y) {
        return single.test(x);
    }
}
