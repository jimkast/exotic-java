package org.jimkast.exotic.bool;

public final class not implements cond {
    private final cond origin;

    public not(cond origin) {
        this.origin = origin;
    }

    @Override
    public <T> T choose(T left, T right) {
        return origin.choose(right, left);
    }
}
