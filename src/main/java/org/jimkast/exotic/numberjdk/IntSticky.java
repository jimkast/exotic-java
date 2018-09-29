package org.jimkast.exotic.numberjdk;

public final class IntSticky extends Int {
    private final Number origin;
    private int cache;
    private int loaded = 0;

    public IntSticky(Number origin) {
        this.origin = origin;
    }

    @Override
    public int intValue() {
        if (loaded++ == 0) {
            cache = origin.intValue();
        }
        return cache;
    }
}
