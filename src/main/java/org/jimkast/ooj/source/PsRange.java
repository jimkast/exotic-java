package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Lt;
import org.jimkast.ooj.lang.Check;
import org.jimkast.ooj.lang.Cond;
import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.lang.Target;

public final class PsRange implements PSource<Integer> {
    private int i = 0;
    private final Check<Integer> chk;

    public PsRange(int max) {
        this(0, max);
    }

    public PsRange(int start, int max) {
        this(start, i -> new Lt(i, max));
    }

    public PsRange(int i, Check<Integer> chk) {
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
