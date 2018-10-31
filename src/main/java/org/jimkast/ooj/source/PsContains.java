package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.cond.Cond;

public final class PsContains<X> extends Cond.Env {
    public PsContains(X item, Source<X> source) {
        super(new PsMatchAny<>(new Check.Eq<>(item), source));
    }
}
