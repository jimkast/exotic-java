package org.jimkast.exotic.possible.gen;

public final class integers extends ScalarEnvelope<Integer> {
    public integers() {
        this(0);
    }

    public integers(int from) {
        this(from, 1);
    }

    public integers(int from, int step) {
        super(new gen1<>(from, i -> i + step));
    }
}
