package org.jimkast.ooj.source;

import org.jimkast.ooj.map.Mapping;
import org.jimkast.ooj.target.RefQueue;

public final class PsOrElse<T> implements Mapping<PSource<T>, T> {
    private final Scalar<T> other;
    private final RefQueue<T> store = new RefQueue<>();

    public PsOrElse(T other) {
        this(new Scalar.Fixed<>(other));
    }

    PsOrElse(Scalar<T> other) {
        this.other = other;
    }

    @Override
    public T map(PSource<T> source) {
        return source.feed(store).choose(other, store).value();
    }
}
