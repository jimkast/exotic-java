package org.jimkast.exotic.memory;

import java.util.Arrays;

public final class copied implements memblockR {
    private final memblockR origin;

    public copied(memblockR origin) {
        this(origin.address(), origin.length().intValue());
    }

    copied(addr b, int length) {
        this.origin = new malloc(Arrays.copyOfRange(b.arr, b.offset, length));
    }

    @Override
    public addr address() {
        return origin.address();
    }

    @Override
    public Number at(Number i) {
        return origin.at(i);
    }

    @Override
    public Number length() {
        return origin.length();
    }
}
