package org.jimkast.ooj.source;

import org.jimkast.ooj.lang.Cond;
import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.lang.Target;

public final class PsForEach<T> implements PSource<T> {
    private final PSource<T> origin;

    public PsForEach(PSource<T> origin) {
        this.origin = origin;
    }

    @Override
    public Cond feed(Target<T> target) {
        if (origin.feed(target).choose(false, true)) {
            return Cond.FALSE;
        }
        while (origin.feed(target).choose(true, false)) ;
        return Cond.TRUE;
    }
}
