package org.jimkast.exotic.possible;

import java.util.function.Consumer;
import org.cactoos.Scalar;
import org.jimkast.exotic.bool.check;

public final class pwhile<T> implements possible<T> {
    private final check<T> check;
    private final Consumer<? super T> other;
    private final possible<T> origin;

    public pwhile(check<T> check, Scalar<T> factory) {
        this(check, new fixed<>(factory));
    }

    public pwhile(check<T> check, possible<T> origin) {
        this(check, o -> {
        }, origin);
    }

    public pwhile(org.jimkast.exotic.bool.check<T> check, Consumer<? super T> other, possible<T> origin) {
        this.check = check;
        this.other = other;
        this.origin = origin;
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
        origin.supply(t -> check.test(t).<Consumer<? super T>>choose(consumer, other).accept(t));
    }
}
