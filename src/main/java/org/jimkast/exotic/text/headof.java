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
    public int map(int index) {
        return origin.map(index);
    }

    @Override
    public int length() {
        return length.intValue();
    }
}
