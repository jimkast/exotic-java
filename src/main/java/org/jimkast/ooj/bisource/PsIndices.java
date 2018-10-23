package org.jimkast.ooj.bisource;

import org.jimkast.ooj.lang.PSource;

public final class PsIndices extends PSource.Env<Integer> {
    public PsIndices(PSource<?> origin) {
        super(new PsBi2<>(new PsWithIndex<>(origin)));
    }
}
