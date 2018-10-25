package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Check;

public final class PsWhile<T> extends PSource.Env<T> {
    public PsWhile(Check<T> check, PSource<T> origin) {
        this(check, Target.Noop.instance(), origin);
    }

    public PsWhile(Check<T> check, Target<T> other, PSource<T> origin) {
        super(new PsStore<>(store -> origin.feed(new TrgCond<>(check, store, other))));
    }
}
