package org.jimkast.ooj.source;

import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.map.Mapping;
import org.jimkast.ooj.target.RefQueue;

public final class PsOrElse<T> implements Mapping<Source<T>, T> {
    private final T other;
    private final ArrayTarget<T> store = new RefQueue<>();

    public PsOrElse(T other) {
        this.other = other;
    }

    @Override
    public T map(Source<T> source) {
        source.feed(store);
        return store.length() == 0 ? other : store.map(0);
    }
}
