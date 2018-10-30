package org.jimkast.ooj.bisource;

import org.jimkast.ooj.source.Source;

public final class BiPs2Simple<T> implements BiSource<T, T> {
    private final Source<T> origin;

    public BiPs2Simple(Source<T> origin) {
        this.origin = origin;
    }

    @Override
    public void feed(BiTarget<T, T> target) {
        origin.feed(t -> origin.feed(t2 -> target.accept(t, t2)));
    }
}
