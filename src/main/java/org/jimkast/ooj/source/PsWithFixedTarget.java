package org.jimkast.ooj.source;

import org.jimkast.ooj.lang.Cond;
import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.lang.Target;

public final class PsWithFixedTarget<T> implements PSource<T> {
    private final Target<T> fixed;
    private final PSource<T> origin;

    public PsWithFixedTarget(Target<T> fixed, PSource<T> origin) {
        this.fixed = fixed;
        this.origin = origin;
    }

    @Override
    public Cond feed(Target<T> target) {
        return origin.feed(fixed);
    }
}
