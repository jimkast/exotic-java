package org.jimkast.exotic.possible.gen;

public final class fibonnaci extends ScalarEnvelope<Integer> {
    public fibonnaci() {
        super(new gen2<>(0, 1, (n1, n2) -> n1 + n2));
    }
}
