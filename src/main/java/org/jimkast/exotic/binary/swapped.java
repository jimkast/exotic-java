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
    public int at(int index) {
        if (index == i) {
            return origin.at(j);
        }
        if (index == j) {
            return origin.at(i);
        }
        return origin.at(index);
    }

    @Override
    public int length() {
        return origin.length();
    }
}
