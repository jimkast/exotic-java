package org.jimkast.exotic.numberjdk;

import org.cactoos.Scalar;

public final class as_int implements Scalar<Integer> {
    private final Number origin;

    public as_int(Number origin) {
        this.origin = origin;
    }

    @Override
    public Integer value() throws Exception {
        return origin.intValue();
    }
}
