package org.jimkast.exotic.possible;

import java.util.function.Consumer;
import org.cactoos.Scalar;
import org.jimkast.exotic.bool.check;
import org.jimkast.exotic.possible.util.CondConsumer;

public final class pwhile<T> implements possible<T> {
    private final check<T> check;
    private final Consumer<? super T> other;
    private final possible<T> origin;

    public pwhile(check<T> check, Scalar<T> factory) {
        this(check, new fixed<>(factory));
    }

    public pwhile(check<T> check, possible<T> origin) {
        this(check, origin, o -> {
        });
    }

    public pwhile(check<T> check, possible<T> origin, Consumer<? super T> other) {
        this.check = check;
        this.other = other;
        this.origin = origin;
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
        origin.supply(new CondConsumer<>(check, consumer, other));
    }
}
