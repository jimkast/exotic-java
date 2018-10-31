package org.jimkast.ooj.cond;

import org.jimkast.ooj.source.PsMatchAll;
import org.jimkast.ooj.source.SourceStream;

public final class And<T> implements Check<T> {
    private final SourceStream<Check<T>> all;

    public And(SourceStream<Check<T>> all) {
        this.all = all;
    }

    @Override
    public Cond test(T t) {
        return new PsMatchAll<>(o -> o.test(t), all.stream());
    }
}
