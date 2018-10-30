package org.jimkast.ooj.bisource;

import org.jimkast.ooj.source.PsRange;
import org.jimkast.ooj.source.Source;

public final class PsWithCounter<T> extends BiSource.Env<T, Integer> {
    public PsWithCounter(Source<T> origin) {
        this(1, origin);
    }

    public PsWithCounter(int i, Source<T> origin) {
        super(new PsBiCombined<>(origin, new PsRange(i)));
    }
}
