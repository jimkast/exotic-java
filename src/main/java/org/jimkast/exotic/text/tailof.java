package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;

public final class tailof implements binary {
    private final binary origin;
    private final Number offset;

    public tailof(binary origin, Number offset) {
        this.origin = origin;
        this.offset = offset;
    }

    @Override
    public int at(int index) {
        return origin.at(index + origin.length() - offset.intValue());
    }

    @Override
    public int length() {
        return offset.intValue();
    }
}
