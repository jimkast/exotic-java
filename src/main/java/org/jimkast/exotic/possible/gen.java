package org.jimkast.exotic.possible;

import java.util.function.Function;
import org.cactoos.Func;
import org.cactoos.Scalar;
import org.jimkast.exotic.bool.cond;

public final class gen<T> implements Scalar<T> {
    private T initial;
    private final Func<T, T> next;
    private cond first = cond.TRUE;

    public gen(T initial, Function<T, T> next) {
        this(initial, (Func<T, T>) input -> next.apply(initial));
    }

    public gen(T initial, Func<T, T> next) {
        this.initial = initial;
        this.next = next;
    }

    @Override
    public T value() throws Exception {
        T current = initial;
        initial = next.apply(current);
        T result = first.choose(current, initial);
        first = cond.FALSE;
        return result;
    }
}
