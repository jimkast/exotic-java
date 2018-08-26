package org.jimkast.exotic.possible;

import org.cactoos.Scalar;
import org.jimkast.exotic.bool.check;
import org.jimkast.exotic.bool.cond;

public final class any<T> implements Scalar<cond> {
    private final Scalar<cond> origin;

    public any(check<T> check, possible<T> possible) {
        this.origin = new orelse<>(
            new mapped<>(
                o -> cond.TRUE,
                new first<>(check, possible)
            ),
            cond.FALSE
        );
    }

    @Override
    public cond value() throws Exception {
        return origin.value();
    }
}
