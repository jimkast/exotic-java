package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;

public final class headof implements binary {
    private final binary origin;
    private final Number length;

    public headof(Number length, binary origin) {
        this.origin = origin;
        this.length = length;
    }

    @Override
    public int at(int index) {
        return origin.at(index);
    }

    @Override
    public int length() {
        return length.intValue();
    }
}
