package org.jimkast.exotic.text;

import org.jimkast.exotic.numberjdk.Int;

public final class substring implements text {
    private final text origin;
    private final Number offset;
    private final Number len;

    public substring(text origin, Number offset) {
        this(origin, offset, new Int() {
            @Override
            public int intValue() {
                return origin.length() - offset.intValue();
            }
        });
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
