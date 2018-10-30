package org.jimkast.ooj.bisource;

import org.jimkast.ooj.source.Source;
import org.jimkast.ooj.source.Target;

public final class PsBi2<T> implements Source<T> {
    private final BiSource<?, T> origin;

    public PsBi2(BiSource<?, T> origin) {
        this.origin = origin;
    }

    @Override
    public void feed(Target<T> target) {
        origin.feed((o, t) -> target.accept(t));
    }
}
