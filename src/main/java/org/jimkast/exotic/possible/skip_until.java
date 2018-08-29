package org.jimkast.exotic.possible;

import java.util.function.Consumer;
import org.cactoos.Scalar;
import org.jimkast.exotic.bool.bool;
import org.jimkast.exotic.bool.check;

public final class skip_until<T> implements possible<T> {
    private final check<T> check;
    private final possible<T> origin;

    public skip_until(Scalar<T> scalar) {
        this(o -> bool.TRUE, scalar);
    }

    public skip_until(check<T> check, Scalar<T> scalar) {
        this(check, new fixed<>(scalar));
    }

    public skip_until(possible<T> origin) {
        this(o -> bool.TRUE, origin);
    }

    public skip_until(check<T> check, possible<T> origin) {
        this.check = check;
        this.origin = origin;
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
        origin.supply(t -> check.test(t).choose(consumer, t1 -> supply(consumer)).accept(t));
    }
}
