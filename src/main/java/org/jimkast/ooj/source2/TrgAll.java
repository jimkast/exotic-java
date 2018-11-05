package org.jimkast.ooj.source2;

import org.jimkast.ooj.source.Target;

public final class TrgAll<T> implements Target<T> {
    private final Iterable<Target<T>> all;

    public TrgAll(Iterable<Target<T>> all) {
        this.all = all;
    }

    @Override
    public void accept(T t) {
        for (Target<T> trg : all) {
            trg.accept(t);
        }
    }
}
