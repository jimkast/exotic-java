package org.jimkast.ooj.bisource;

import org.jimkast.ooj.source.Scalar;
import org.jimkast.ooj.source.Source;
import org.jimkast.ooj.source.Target;

public final class SrcInts implements Source<Integer>, Scalar<Integer> {
    private int i;
    private final int step;

    public SrcInts() {
        this(1);
    }

    public SrcInts(int i) {
        this(i, 1);
    }

    public SrcInts(int i, int step) {
        this.i = i;
        this.step = step;
    }

    @Override
    public void feed(Target<Integer> target) {
        target.accept(value());
    }

    @Override
    public Integer value() {
        return i += step;
    }
}
