package org.jimkast.exotic.possible.gen;

import org.cactoos.Func;

public final class gen1<T> extends ScalarEnvelope<T> {
    public gen1(T start, Func<T, T> next) {
        super(new gen<>(input -> next.apply(input.get(0)), start));
    }
}
