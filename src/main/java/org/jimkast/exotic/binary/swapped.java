package org.jimkast.exotic.binary;

public final class swapped implements binary {
    private final int i;
    private final int j;
    private final binary origin;

    public swapped(int i, int j, binary origin) {
        this.i = i;
        this.j = j;
        this.origin = origin;
    }

    @Override
    public int map(int index) {
        if (index == i) {
            return origin.map(j);
        }
        if (index == j) {
            return origin.map(i);
        }
        return origin.map(index);
    }

    @Override
    public int length() {
        return origin.length();
    }
}
