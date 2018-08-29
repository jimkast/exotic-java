package org.jimkast.exotic.possible;

import org.cactoos.scalar.UncheckedScalar;
import org.jimkast.exotic.bool.bool;
import org.jimkast.exotic.bool.check;

public final class any<T> implements bool {
    private final UncheckedScalar<bool> origin;

    public any(check<T> check, possible<T> possible) {
        this.origin = new UncheckedScalar<>(
            new orelse<>(
                new mapped<>(
                    o -> bool.TRUE,
                    new skip_until<>(check, possible)
                ),
                bool.FALSE
            )
        );
    }

    @Override
    public <X> X choose(X left, X right) {
        return origin.value().choose(left, right);
    }
}
