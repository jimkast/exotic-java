package org.jimkast.exotic.possible.gen;

import org.jimkast.exotic.numberjdk.NumberEnvelope;

public final class sums extends NumberEnvelope {
    public sums(Number gen) {
        super(new gen1<>(0, i -> i + gen.intValue()));
    }
}
