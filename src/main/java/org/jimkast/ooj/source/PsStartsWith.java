package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.cond.Cond;

public final class PsStartsWith<X> extends Cond.Env {
    public PsStartsWith(X item, Source<X> source) {
        super(new PsIsEmpty<>(
            new PsWhile<>(
                new Check.Eq<>(item),
                source
            )
        ));
    }
}
