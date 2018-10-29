package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;

public final class tailof implements binary {
    private final binary origin;
    private final Number offset;

    public tailof(Number offset, binary origin) {
        this.origin = origin;
        this.offset = offset;
    }

    @Override
    public int map(int index) {
        return origin.map(index + origin.length() - offset.intValue());
    }

    @Override
    public int length() {
        return offset.intValue();
    }
}
