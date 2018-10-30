package org.jimkast.ooj.source;

import org.jimkast.ooj.bisource.PsBi2;
import org.jimkast.ooj.bisource.PsBiCombined2;

public final class PsLimited<T> extends Source.Env<T> {
    public PsLimited(Number max, Source<T> origin) {
        super(new PsBi2<>(
            new PsBiCombined2<>(
                new PsRange(max),
                origin
            )
        ));
    }
}
