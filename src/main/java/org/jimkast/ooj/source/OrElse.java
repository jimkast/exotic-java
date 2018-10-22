package org.jimkast.ooj.source;

import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.lang.Scalar;

public final class OrElse<T> extends Scalar.Env<T> {
    public OrElse(T other, PSource<T> origin) {
        super(new ScalarSource<>(new PsAsSource<>(new PsFallback<>(other, origin))));
    }
}
