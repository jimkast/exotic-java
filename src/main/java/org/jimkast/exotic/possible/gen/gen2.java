package org.jimkast.exotic.possible.gen;

import org.cactoos.BiFunc;

public final class gen2<T> extends ScalarEnvelope<T> {
    public gen2(T s1, T s2, BiFunc<T, T, T> next) {
        super(new gen<>(input -> next.apply(input.get(0), input.get(1)), s1, s2));
    }
}
