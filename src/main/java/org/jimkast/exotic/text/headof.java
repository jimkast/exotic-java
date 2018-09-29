package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;

public final class headof implements binary {
    private final binary origin;
    private final Number offset;

    public headof(binary origin, Number offset) {
        this.origin = origin;
        this.offset = offset;
    }

    @Override
    public int at(int index) {
        return origin.at(index);
    }

    @Override
    public int length() {
        return origin.length() - offset.intValue();
    }
}
