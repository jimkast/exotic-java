package org.jimkast.ooj.cond;

public final class ChkLte implements Check<Number> {
    private final Number left;

    public ChkLte(Number left) {
        this.left = left;
    }

    @Override
    public Cond test(Number number) {
        return left.intValue() >= number.intValue() ? Cond.TRUE : Cond.FALSE;
    }
}
