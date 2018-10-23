package org.jimkast.ooj.cond;

import org.jimkast.ooj.lang.Check;
import org.jimkast.ooj.lang.Cond;

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
