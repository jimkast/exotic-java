package org.jimkast.exotic.numberjdk;

import org.cactoos.Scalar;

public final class as_long implements Scalar<Long> {
    private final Number origin;

    public as_long(Number origin) {
        this.origin = origin;
    }

    @Override
    public Long value() throws Exception {
        return origin.longValue();
    }
}
