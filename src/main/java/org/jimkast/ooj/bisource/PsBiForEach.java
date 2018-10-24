package org.jimkast.ooj.bisource;

import org.jimkast.ooj.lang.BiPSource;
import org.jimkast.ooj.lang.BiTarget;
import org.jimkast.ooj.lang.Cond;

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
