package org.jimkast.exotic.text;

import org.jimkast.exotic.number.sub;

public final class substring implements text {
    private final text origin;
    private final Number offset;
    private final Number len;

    public substring(text origin, Number offset) {
        this(origin, offset, new sub(new text.length(origin), offset));
    }

    public substring(text origin, Number offset, Number len) {
        this.origin = origin;
        this.offset = offset;
        this.len = len;
    }

    @Override
    public char at(int index) {
        return origin.at(offset.intValue() + index);
    }

    @Override
    public int length() {
        return len.intValue();
    }
}
