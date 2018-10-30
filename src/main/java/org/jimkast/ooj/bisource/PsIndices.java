package org.jimkast.ooj.bisource;

import org.jimkast.ooj.source.Source;

public final class PsIndices extends Source.Env<Integer> {
    public PsIndices(Source<?> origin) {
        this(1, origin);
    }

    public PsIndices(int start, Source<?> origin) {
        super(new PsBi2<>(new PsWithCounter<>(start, origin)));
    }
}
