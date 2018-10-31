package org.jimkast.ooj.cond;

import org.jimkast.ooj.source.PsMatchAny;
import org.jimkast.ooj.source.SourceStream;

public final class Or<T> implements Check<T> {
    private final SourceStream<Check<T>> all;

    public Or(SourceStream<Check<T>> all) {
        this.all = all;
    }

    @Override
    public Cond test(T t) {
        return new PsMatchAny<>(o -> o.test(t), all.stream());
    }
}
