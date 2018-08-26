package org.jimkast.exotic.possible;

import java.util.function.Consumer;
import org.jimkast.exotic.bool.cond;

public final class ConditionalVal<T> implements possible<T> {
    private final org.jimkast.exotic.bool.cond cond;
    private final T val;

    public ConditionalVal(cond cond, T val) {
        this.cond = cond;
        this.val = val;
    }

    @Override
    public void ifPresent(Consumer<? super T> consumer) {
        cond.choose(consumer, o -> {
        }).accept(val);
    }
}
