package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Cond;

public final class PsIsEmpty<X> extends Cond.Env {
    public PsIsEmpty(Source<X> source) {
        super(new Not(new PsNotEmpty<>(source)));
    }
}
