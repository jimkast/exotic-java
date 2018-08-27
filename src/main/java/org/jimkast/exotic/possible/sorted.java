package org.jimkast.exotic.possible;

import java.util.Comparator;
import org.cactoos.iterable.IterableOf;
import org.cactoos.iterable.Sorted;
import org.jimkast.exotic.possible.adapter.AsIterator;
import org.jimkast.exotic.possible.adapter.iterable;

public final class sorted<T> extends possible.env<T> {
    @SuppressWarnings("unchecked")
    public sorted(possible<T> origin) {
        this((Comparator<T>) Comparator.naturalOrder(), origin);
    }

    public sorted(Comparator<T> cmp, possible<T> origin) {
        super(new iterable<>(new Sorted<>(cmp, new IterableOf<>(new AsIterator<>(origin)))));
    }
}
