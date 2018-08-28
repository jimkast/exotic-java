package org.jimkast.exotic.possible;

import java.util.function.Consumer;

public final class count extends Number implements Consumer<Object> {
    private final possible<?> p;
    private long i = 0;

    public count(possible<?> p) {
        this.p = p;
    }

    @Override
    public int intValue() {
        p.supply(this);
        return (int) i;
    }

    @Override
    public long longValue() {
        return i;
    }

    @Override
    public float floatValue() {
        return i;
    }

    @Override
    public double doubleValue() {
        return i;
    }

    @Override
    public void accept(Object o) {
        i++;
    }
}
