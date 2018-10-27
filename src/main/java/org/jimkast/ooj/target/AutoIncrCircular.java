package org.jimkast.ooj.target;

import org.jimkast.exotic.numberjdk.Int;

public final class AutoIncrCircular extends Int {
    private final int size;
    private int i;

    public AutoIncrCircular(int size) {
        this(size, 0);
    }

    public AutoIncrCircular(int size, int i) {
        this.size = size;
        this.i = i;
    }

    @Override
    public int intValue() {
        int temp = i;
        i = (i + 1) % size;
        return temp;
    }
}
