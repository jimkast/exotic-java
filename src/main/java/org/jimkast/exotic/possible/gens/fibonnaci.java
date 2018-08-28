package org.jimkast.exotic.possible.gens;

public final class fibonnaci extends ScalarEnvelope<Integer> {
    public fibonnaci() {
        super(new gen<>(store -> store.get(0) + store.get(1), 0, 1));
    }
}
