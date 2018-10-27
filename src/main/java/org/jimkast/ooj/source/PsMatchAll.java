package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.cond.Cond;

public final class PsMatchAll<T> extends Cond.Env {
    public PsMatchAll(Check<T> check, PSource<T> source) {
        super(new PsIsEmpty<>(new PsFiltered<>(new Check.Not<>(check), source)));
    }
}
