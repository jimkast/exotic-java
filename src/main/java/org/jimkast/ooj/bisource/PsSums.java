package org.jimkast.ooj.bisource;

import org.jimkast.ooj.lang.Cond;
import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.lang.Target;

public final class PsSums implements PSource<Number> {
    private final PSource<Number> origin;
    private int sum = 0;

    public PsSums(PSource<Number> origin) {
        this.origin = origin;
    }

    @Override
    public Cond feed(Target<Number> target) {
        return origin.feed(n -> target.accept(sum += n.intValue()));
    }
}
