package org.jimkast.ooj.bisource;

import org.jimkast.ooj.lang.BiPSource;
import org.jimkast.ooj.lang.PSource;

public final class PsWithIndex<T> extends BiPSource.Env<T, Integer> {
    public PsWithIndex(PSource<T> origin) {
        this(0, origin);
    }

    public PsWithIndex(int i, PSource<T> origin) {
        super(new PsBiCombined<>(origin, new SrcInts(i)));
    }
}
