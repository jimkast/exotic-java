package org.jimkast.ooj.bool;

import java.util.function.Predicate;

public final class ChkEq<T> implements Predicate<T> {
    private final T t;

    public ChkEq(T t) {
        this.t = t;
    }

    @Override
    public boolean test(T t) {
        return this.t.equals(t);
    }
}
