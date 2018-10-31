package org.jimkast.ooj.source;

import java.util.Arrays;

public final class PsOfIterable<T> implements SourceStream<T>, Source<Source<T>> {
    private final Iterable<T> items;

    @SafeVarargs
    public PsOfIterable(T... items) {
        this(Arrays.asList(items));
    }

    public PsOfIterable(Iterable<T> items) {
        this.items = items;
    }

    @Override
    public Source<T> stream() {
        return new PsOfIterator<>(items.iterator());
    }

    @Override
    public void feed(Target<Source<T>> target) {
        target.accept(new PsOfIterator<>(items.iterator()));
    }
}
