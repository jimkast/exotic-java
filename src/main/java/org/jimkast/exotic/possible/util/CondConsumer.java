package org.jimkast.exotic.possible.util;

import java.util.function.Consumer;
import org.jimkast.exotic.bool.check;

public final class CondConsumer<T> implements Consumer<T> {
    private final check<T> check;
    private final Consumer<? super T> c1;
    private final Consumer<? super T> c2;

    public CondConsumer(check<T> check, Consumer<? super T> c1) {
        this(check, c1, t -> {
        });
    }

    public CondConsumer(check<T> check, Consumer<? super T> c1, Consumer<? super T> c2) {
        this.check = check;
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public void accept(T t) {
        check.test(t).<Consumer<? super T>>choose(c1, c2).accept(t);
    }
}
