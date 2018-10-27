package org.jimkast.ooj.source;

import java.util.Arrays;
import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.target.RefQueue;

public final class PsFlattened<T> implements PSource<T> {
    private final PSource<PSource<T>> sources;
    private final Store<PSource<T>> store;

    @SafeVarargs
    public PsFlattened(PSource<T>... sources) {
        this(new PsOfIterator<>(Arrays.asList(sources).iterator()));
    }

    public PsFlattened(PSource<PSource<T>> sources) {
        this(sources, new RefQueue<>());
    }

    PsFlattened(PSource<PSource<T>> sources, Store<PSource<T>> store) {
        this.sources = sources;
        this.store = store;
    }

    @Override
    public Cond feed(Target<T> target) {
        return new PsFiltered<>(
            src -> src.feed(target),
            new PsFallback<>(sources, store)
        ).feed(store);
    }
}
