package org.jimkast.exotic.string;

public final class WithLength implements Countable {
    private final int length;

    public WithLength(int length) {
        this.length = length;
    }

    @Override
    public int length() {
        return length;
    }
}