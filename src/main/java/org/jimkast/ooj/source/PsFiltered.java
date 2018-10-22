package org.jimkast.ooj.source;

import org.jimkast.ooj.lang.Check;
import org.jimkast.ooj.lang.PSource;

public final class PsFiltered<T> extends PSource.Env<T> {
    public PsFiltered(Check<T> check, PSource<T> origin) {
        super(new PsForAll<>(new PsCond<>(check, origin)));
    }
}
