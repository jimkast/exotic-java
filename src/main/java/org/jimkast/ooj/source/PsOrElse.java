package org.jimkast.ooj.source;

import org.jimkast.ooj.lang.Array;
import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.map.Mapping;
import org.jimkast.ooj.target.ObjectArray;
import org.jimkast.ooj.target.RefQueue;

public final class PsOrElse<T> implements Mapping<PSource<T>, T> {
    private final Array<T> other;
    private final ArrayTarget<T> store = new RefQueue<>();

    public PsOrElse(T other) {
        this(new ObjectArray.Native<>(other));
    }

    PsOrElse(Array<T> other) {
        this.other = other;
    }

    @Override
    public T map(PSource<T> source) {
        return source.feed(store).choose(other, store).map(0);
    }
}
