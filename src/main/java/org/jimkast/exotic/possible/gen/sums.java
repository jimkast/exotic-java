package org.jimkast.exotic.possible.gen;

import org.cactoos.Scalar;
import org.jimkast.exotic.number.add;
import org.jimkast.exotic.numberjdk.NumberEnvelope;

public final class sums extends NumberEnvelope {
    public sums(Number gen) {
        this(() -> gen);
    }

    public sums(Scalar<Number> gen) {
        super(new gen1<Number>(0, input -> new add(input, gen.value())));
    }
}
