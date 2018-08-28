package org.jimkast.exotic.possible;

import org.cactoos.Func;
import org.jimkast.exotic.possible.gens.ScalarEnvelope;
import org.jimkast.exotic.possible.gens.gen;

public final class gen1<T> extends ScalarEnvelope<T> {
    public gen1(T start, Func<T, T> next) {
        super(new gen<>(
            input -> next.apply(input.get(0)),
            start
        ));
    }
}
