package org.jimkast.exotic.possible;

import org.cactoos.Scalar;
import org.jimkast.exotic.bool.check;
import org.jimkast.exotic.bool.cond;

public final class all<T> implements Scalar<cond> {
    private final Scalar<cond> origin;

    public all(check<T> check, possible<T> possible) {
        this.origin = new orelse<>(
            new mapped<>(
                o -> cond.FALSE,
                new first<>(check, possible)
            ),
            cond.TRUE
        );
    }

    @Override
    public cond value() throws Exception {
        return origin.value();
    }
}
