package org.jimkast.ooj.bisource;

import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.source.Source;
import org.jimkast.ooj.lang.Quantity;
import org.jimkast.ooj.source.PsWhile;

public final class PsIndexOf<T> extends Quantity.Env {
    public PsIndexOf(T o, Source<T> source) {
        this(new Check.Eq<>(o), source);
    }

    public PsIndexOf(Check<T> check, Source<T> source) {
        super(new PsSize(-1, new PsWhile<>(check, source)));
    }
}
