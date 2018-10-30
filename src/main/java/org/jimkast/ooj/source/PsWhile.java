package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Check;

public final class PsWhile<T> extends Source.Env<T> {
    public PsWhile(Check<T> check, Source<T> origin) {
        this(check, Target.Noop.instance(), origin);
    }

    public PsWhile(Check<T> check, Target<T> other, Source<T> origin) {
        super(new PsStore<>(store -> origin.feed(new TrgCond<>(check, store, other))));
    }
}
