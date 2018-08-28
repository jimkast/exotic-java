package org.jimkast.exotic.possible.gens;

import org.cactoos.Scalar;
import org.jimkast.exotic.number.add;
import org.jimkast.exotic.possible.gen1;

public final class sums extends ScalarEnvelope<Number> {
    public sums(Scalar<Number> gen) {
        super(new gen1<>(0, input -> new add(input, gen.value())));
    }

}
