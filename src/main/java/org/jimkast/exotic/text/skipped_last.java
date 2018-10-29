package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;

public final class skipped_last implements binary {
    private final binary origin;
    private final Number offset;

    public skipped_last(Number offset, binary origin) {
        this.origin = origin;
        this.offset = offset;
    }

    @Override
    public int map(int index) {
        return origin.map(index);
    }

    @Override
    public int length() {
        return origin.length() - offset.intValue();
    }
}
