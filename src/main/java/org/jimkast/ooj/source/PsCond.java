package org.jimkast.ooj.source;

import org.jimkast.ooj.lang.Check;
import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.lang.Target;

public final class PsCond<T> extends PSource.Env<T> {
    public PsCond(Check<T> check, PSource<T> origin) {
        this(check, Target.Noop.instance(), origin);
    }

    public PsCond(Check<T> check, Target<T> other, PSource<T> origin) {
        super(new PsStore<>(store -> origin.feed(new TrgCond<>(check, store, other))));
    }
}
