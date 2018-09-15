package org.jimkast.exotic.possible;

import java.util.function.Consumer;
import org.cactoos.Scalar;
import org.jimkast.exotic.bool.check;

public final class pwhile<T> implements possible<T> {
    private final check<T> check;
    private final possible<T> origin;

    public pwhile(check<T> check, Scalar<T> factory) {
        this(check, new fixed<>(factory));
    }

    public pwhile(check<T> check, possible<T> origin) {
        this.check = check;
        this.origin = origin;
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
        origin.supply(t -> check.test(t).choose(consumer, o -> {
        }).accept(t));
    }
}