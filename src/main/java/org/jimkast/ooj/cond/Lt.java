package org.jimkast.ooj.cond;

public final class Lt implements Cond {
    private final Number n1;
    private final Number n2;

    public Lt(Number n1, Number n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public <T> T choose(T main, T other) {
        return n1.intValue() < n2.intValue() ? main : other;
    }
}
