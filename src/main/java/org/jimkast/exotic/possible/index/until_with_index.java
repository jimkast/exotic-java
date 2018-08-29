package org.jimkast.exotic.possible.index;

import java.util.function.Consumer;
import org.jimkast.exotic.bool.bicheck;
import org.jimkast.exotic.possible.possible;

public final class until_with_index<T> implements possible<T> {
    private final bicheck<T, Integer> check;
    private final with_index<T> origin;

    public until_with_index(bicheck<T, Integer> check, possible<T> origin) {
        this(check, new with_index<>(origin));
    }

    public until_with_index(bicheck<T, Integer> check, with_index<T> origin) {
        this.check = check;
        this.origin = origin;
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
        origin.supply((t, i) -> check.test(t, i).choose(consumer, t1 -> {
        }).accept(t));
    }
}
