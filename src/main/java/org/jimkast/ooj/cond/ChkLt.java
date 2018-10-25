package org.jimkast.ooj.cond;

public final class ChkLt implements Check<Number> {
    private final Number left;

    public ChkLt(Number left) {
        this.left = left;
    }

    @Override
    public Cond test(Number number) {
        return left.intValue() > number.intValue() ? Cond.TRUE : Cond.FALSE;
    }
}
