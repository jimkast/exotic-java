package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Cond;

public final class PsWithFixedTarget<T> implements PSource<T> {
    private final Target<T> target;
    private final PSource<T> source;

    public PsWithFixedTarget(Target<T> target, PSource<T> source) {
        this.target = target;
        this.source = source;
    }

    @Override
    public Cond feed(Target<T> target) {
        return source.feed(this.target);
    }
}
