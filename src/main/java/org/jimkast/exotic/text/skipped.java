package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;

public final class skipped implements binary {
    private final binary origin;
    private final Number offset;

    public skipped(binary origin, Number offset) {
        this.origin = origin;
        this.offset = offset;
    }

    @Override
    public int at(int index) {
        return origin.at(index + offset.intValue());
    }

    @Override
    public int length() {
        return origin.length() - offset.intValue();
    }
}
