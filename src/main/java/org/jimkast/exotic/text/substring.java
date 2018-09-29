package org.jimkast.exotic.text;

import org.jimkast.exotic.number.sub;

public final class substring implements binary {
    private final binary origin;
    private final Number offset;
    private final Number len;

    public substring(binary origin, Number offset) {
        this(origin, offset, new sub(new binary.length(origin), offset));
    }

    public substring(binary origin, Number offset, Number len) {
        this.origin = origin;
        this.offset = offset;
        this.len = len;
    }

    @Override
    public int at(int index) {
        return origin.at(offset.intValue() + index);
    }

    @Override
    public int length() {
        return len.intValue();
    }
}
