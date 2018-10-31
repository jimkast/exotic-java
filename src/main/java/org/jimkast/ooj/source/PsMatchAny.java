package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.cond.Cond;

public final class PsMatchAny<T> extends Cond.Env {
    public PsMatchAny(Check<T> check, Source<T> source) {
        super(new PsNotEmpty<>(new PsFiltered<>(check, source)));
    }
}
