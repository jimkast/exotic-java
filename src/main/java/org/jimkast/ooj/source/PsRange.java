package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.cond.ChkLte;
import org.jimkast.ooj.lang.Quantity;

public final class PsRange extends Source.Env<Integer> {
    public PsRange(Quantity q) {
        this(0, q);
    }

    public PsRange(int start, Quantity q) {
        this(start, new Quantity.AsInt(q));
    }

    public PsRange(Number max) {
        this(0, max);
    }

    public PsRange(int start, Number max) {
        this(start, new ChkLte(max));
    }

    public PsRange(int i, Check<Number> chk) {
        super(new PsWhile<>(chk::test, new PsInts(i)));
    }
}
