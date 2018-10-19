package org.jimkast.exotic.possible.util;

import java.util.function.Consumer;
import org.jimkast.exotic.possible.possible;

public final class PossibleAsRunnable<T> implements Runnable {
    private final possible<T> p;
    private final Consumer<? super T> c;

    public PossibleAsRunnable(possible<T> p, Consumer<? super T> c) {
        this.p = p;
        this.c = c;
    }

    @Override
    public void run() {
        p.supply(c);
    }
}
