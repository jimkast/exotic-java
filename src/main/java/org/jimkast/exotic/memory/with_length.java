package org.jimkast.exotic.memory;

public final class with_length implements memblockR {
    private final Number len;
    private final memblockR origin;

    public with_length(Number len, memblockR origin) {
        this.len = len;
        this.origin = origin;
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
        return len.intValue();
    }
}
