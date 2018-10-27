package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.cond.Cond;

public final class PsMatchAny<T> extends Cond.Env {
    public PsMatchAny(T item, PSource<T> source) {
        this(new Check.Eq<>(item), source);
    }

    public PsMatchAny(Check<T> check, PSource<T> source) {
        super(new PsNotEmpty<>(new PsFiltered<>(check, source)));
    }
}
