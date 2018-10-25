package org.jimkast.ooj.source;

import java.util.Iterator;
import org.jimkast.ooj.map.Mapping;
import org.jimkast.ooj.source.PSource;
import org.jimkast.ooj.source.StoreQueue;
import org.jimkast.ooj.source.adapter.IteratorFixed;

public final class PsOrElse<T> implements Mapping<PSource<T>, T> {
    private final Iterator<T> other;
    private final StoreQueue<T> store = new StoreQueue<>();

    public PsOrElse(T other) {
        this(new IteratorFixed<>(other));
    }

    PsOrElse(Iterator<T> other) {
        this.other = other;
    }

    @Override
    public T map(PSource<T> source) {
        return source.feed(store).choose(other, store).next();
    }
}
