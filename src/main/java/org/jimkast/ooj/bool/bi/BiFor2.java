package org.jimkast.ooj.bool.bi;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public final class BiFor2<X, Y> implements BiPredicate<X, Y> {
    private final Predicate<? super Y> single;

    public BiFor2(Predicate<? super Y> single) {
        this.single = single;
    }

    @Override
    public boolean test(X x, Y y) {
        return single.test(y);
    }
}
