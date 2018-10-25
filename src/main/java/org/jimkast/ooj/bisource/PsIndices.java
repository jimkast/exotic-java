package org.jimkast.ooj.bisource;

import org.jimkast.ooj.source.PSource;

public final class PsIndices extends PSource.Env<Integer> {
    public PsIndices(PSource<?> origin) {
        this(1, origin);
    }

    public PsIndices(int start, PSource<?> origin) {
        super(new PsBi2<>(new PsWithIndex<>(start, origin)));
    }
}
