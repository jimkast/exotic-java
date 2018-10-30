package org.jimkast.ooj.source;

import org.jimkast.ooj.bisource.PsLast;
import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.cond.Cond;

public final class PsEndsWith<X> extends Cond.Env {
    public PsEndsWith(X item, Source<X> source) {
        super(
            new PsIsEmpty<>(
                new PsWhile<>(
                    new Check.Eq<>(item),
                    new PsLast<>(source)
                )
            )
        );
    }
}
