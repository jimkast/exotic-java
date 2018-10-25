package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.ChkLte;
import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.cond.Cond;

public final class PsRange implements PSource<Integer> {
    private int i;
    private final Check<Number> chk;

    public PsRange(int max) {
        this(0, max);
    }

    public PsRange(int start, int max) {
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
