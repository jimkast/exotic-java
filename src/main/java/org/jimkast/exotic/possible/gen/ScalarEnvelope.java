package org.jimkast.exotic.possible.gen;

import org.cactoos.Scalar;

public class ScalarEnvelope<T> implements Scalar<T> {
    private final Scalar<T> origin;

    public ScalarEnvelope(Scalar<T> origin) {
        this.origin = origin;
    }

    @Override
    public final T value() throws Exception {
        return origin.value();
    }
}
