package org.jimkast.ooj.bisource;

import org.jimkast.ooj.lang.Check;
import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.lang.Quantity;
import org.jimkast.ooj.source.PsWhile;

public final class PsIndexOf<T> extends Quantity.Env {
    public PsIndexOf(T o, PSource<T> source) {
        this(new Check.Eq<>(o), source);
    }

    public PsIndexOf(Check<T> check, PSource<T> source) {
        super(new PsSize(new PsWhile<>(check, source)));
    }
}
