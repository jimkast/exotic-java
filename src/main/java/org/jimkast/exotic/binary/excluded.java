package org.jimkast.exotic.binary;

public final class excluded implements binary {
    private final int index;
    private final binary origin;

    public excluded(int index, binary origin) {
        this.index = index;
        this.origin = origin;
    }

    @Override
    public int map(int i) {
        return index >= i ? origin.map(i + 1) : origin.map(i);
    }

    @Override
    public int length() {
        return origin.length() - 1;
    }
}
