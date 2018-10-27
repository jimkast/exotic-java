package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Check;

public final class PsFiltered<T> extends PSource.Env<T> {
    public PsFiltered(Check<T> check, PSource<T> origin) {
        this(new Check.Not<>(check), Target.Noop.instance(), origin);
    }

    private PsFiltered(Check<T> check, Target<T> noop, PSource<T> origin) {
        super(new PsStore<>(
            new PsMapping<>(store ->
                new PsWithFixedTarget<>(noop,
                    new PsForEach<>(
                        new PsWhile<>(check, store, origin)
                    )
                )
            )
        ));
    }
}
