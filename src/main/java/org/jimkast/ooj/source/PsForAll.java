package org.jimkast.ooj.source;

import org.jimkast.ooj.lang.Cond;
import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.lang.Target;

public final class PsForAll<T> implements PSource<T> {
    private final PSource<T> origin;

    public PsForAll(PSource<T> origin) {
        this.origin = origin;
    }

    @Override
    public Cond feed(Target<T> target) {
        boolean b = origin.feed(target).choose(true, false);
        if (!b) return Cond.FALSE;
        while (origin.feed(target).choose(true, false)) ;
        return Cond.TRUE;
    }
}
