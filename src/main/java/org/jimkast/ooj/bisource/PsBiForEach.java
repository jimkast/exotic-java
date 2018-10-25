package org.jimkast.ooj.bisource;

import org.jimkast.ooj.cond.Cond;

public final class PsBiForEach<X, Y> implements BiPSource<X, Y> {
    private final BiPSource<X, Y> origin;

    public PsBiForEach(BiPSource<X, Y> origin) {
        this.origin = origin;
    }

    @Override
    public Cond feed(BiTarget<X, Y> target) {
        if (origin.feed(target).choose(false, true)) {
            return Cond.FALSE;
        }
        while (origin.feed(target).choose(true, false)) ;
        return Cond.TRUE;
    }
}
