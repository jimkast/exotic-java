package org.jimkast.ooj.source;

import org.jimkast.ooj.lang.Cond;
import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.lang.Target;

public final class PsFallback<T> implements PSource<T> {
    private final PSource<T> other;
    private final PSource<T> origin;

    public PsFallback(T fixed, PSource<T> origin) {
        this(new PSource.Fixed<>(fixed), origin);
    }

    public PsFallback(PSource<T> other, PSource<T> origin) {
        this.other = other;
        this.origin = origin;
    }

    @Override
    public Cond feed(Target<T> target) {
        return origin.feed(target).<PSource<T>>choose(PSource.Empty.instance(), other).feed(target);
    }
}
