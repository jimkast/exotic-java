package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Cond;

public final class PsTee<T> implements PSource<T> {
    private final Target<T> output;
    private final PSource<T> origin;

    public PsTee(Store<T> output, PSource<T> origin) {
        this.output = output;
        this.origin = origin;
    }

    @Override
    public Cond feed(Target<T> target) {
        return origin.feed(new Target.Both<>(target, output));
    }
}
