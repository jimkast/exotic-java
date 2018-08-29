package org.jimkast.exotic.possible;

import java.util.function.BiConsumer;
import org.cactoos.Scalar;

public final class combined2<T1, T2> implements possible2<T1, T2> {
    private final possible<T1> p1;
    private final possible<T2> p2;

    public combined2(possible<T1> p1, Scalar<T2> p2) {
        this(p1, new possible.fixed<>(p2));
    }

    public combined2(possible<T1> p1, possible<T2> p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void supply(BiConsumer<? super T1, ? super T2> consumer) {
        p1.supply(t1 -> p2.supply(t2 -> consumer.accept(t1, t2)));
    }
}
