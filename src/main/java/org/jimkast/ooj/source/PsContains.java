package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Cond;

public final class PsContains<X> extends Cond.Env {
    public PsContains(X item, PSource<X> source) {
        super(new PsMatchAny<>(item, source));
    }
}
