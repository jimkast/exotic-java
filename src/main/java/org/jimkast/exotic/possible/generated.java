package org.jimkast.exotic.possible;

import java.util.function.Consumer;
import org.cactoos.Scalar;
import org.cactoos.scalar.UncheckedScalar;
import org.jimkast.exotic.bool.check;

public final class generated<T> implements possible<T> {
    private final check<T> check;
    private final UncheckedScalar<T> factory;

    public generated(check<T> check, Scalar<T> factory) {
        this(check, new UncheckedScalar<>(factory));
    }

    public generated(check<T> check, UncheckedScalar<T> factory) {
        this.check = check;
        this.factory = factory;
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
        T val = factory.value();
        check.test(val).choose(consumer, t -> {}).accept(val);
    }
}
