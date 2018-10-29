package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;

public final class skipped implements binary {
    private final binary origin;
    private final Number offset;

    public skipped(Number offset, binary origin) {
        this.origin = origin;
        this.offset = offset;
    }

    @Override
    public int map(int index) {
        return origin.map(index + offset.intValue());
    }

    @Override
    public int length() {
        return origin.length() - offset.intValue();
    }
}
