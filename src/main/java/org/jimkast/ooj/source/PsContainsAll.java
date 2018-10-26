package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Cond;

public final class PsContainsAll<X> extends Cond.Env {
    public PsContainsAll(PSource<X> items, PSource<X> source) {
        super(new PsMatchAll<>(
            x -> new PsMatchAny<>(x, source),
            items
        ));
    }
}