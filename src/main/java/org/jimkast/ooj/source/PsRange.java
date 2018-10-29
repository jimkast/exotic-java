package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.cond.ChkLte;
import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.lang.Quantity;

public final class PsRange implements PSource<Integer> {
    private int i;
    private final Check<Number> chk;

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
        this.i = i;
        this.chk = chk;
    }

    @Override
    public Cond feed(Target<Integer> target) {
        Cond c = chk.test(i);
        c.choose(target, Target.Noop.<Integer>instance()).accept(i++);
        return c;
    }
}
