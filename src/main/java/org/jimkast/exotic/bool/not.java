package org.jimkast.exotic.bool;

public final class not implements bool {
    private final bool origin;

    public not(bool origin) {
        this.origin = origin;
    }

    @Override
    public <T> T choose(T left, T right) {
        return origin.choose(right, left);
    }
}
