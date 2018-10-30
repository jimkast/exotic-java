package org.jimkast.ooj.source;

import java.util.Arrays;
import org.jimkast.ooj.target.RefQueue;

public final class PsFlattened<T> implements Source<T> {
    private final Source<Source<T>> sources;
    private final Store<Source<T>> store;

    @SafeVarargs
    public PsFlattened(Source<T>... sources) {
        this(new PsOfIterator<>(Arrays.asList(sources).iterator()));
    }

    public PsFlattened(Source<Source<T>> sources) {
        this(sources, new RefQueue<>());
    }

    PsFlattened(Source<Source<T>> sources, Store<Source<T>> store) {
        this.sources = sources;
        this.store = store;
    }

    @Override
    public void feed(Target<T> target) {
        new PsFiltered<>(
            src -> new CondSource.Default<>(src).feed(target),
            new PsFallback<>(sources, store)
        ).feed(store);
    }
}
