package org.jimkast.exotic.possible;

import java.util.function.Consumer;
import java.util.function.Function;
import org.jimkast.exotic.bool.check;

public final class generated<T> implements possible<T> {
    private T val;
    private final check<T> check;
    private final Function<T, T> next;

    public generated(T initial, check<T> check, Function<T, T> next) {
        this.val = initial;
        this.check = check;
        this.next = next;
    }

    @Override
    public void ifPresent(Consumer<? super T> consumer) {
        T current = val;
        val = next.apply(current);
        check.test(current).choose(consumer, t -> {
        }).accept(current);
    }
}
