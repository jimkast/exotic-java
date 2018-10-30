package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.cond.Cond;

public final class PsMatchAny<T> extends Cond.Env {
    public PsMatchAny(T item, Source<T> source) {
        this(new Check.Eq<>(item), source);
    }

    public PsMatchAny(Check<T> check, Source<T> source) {
        super(new PsNotEmpty<>(new PsFiltered<>(check, source)));
    }
}
