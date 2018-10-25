package org.jimkast.ooj.source;

public final class OrElse<T> extends Scalar.Env<T> {
    public OrElse(T other, PSource<T> origin) {
        super(new ScalarSource<>(new PsAsSource<>(new PsFallback<>(other, origin))));
    }
}
