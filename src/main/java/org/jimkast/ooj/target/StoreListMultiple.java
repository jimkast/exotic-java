package org.jimkast.ooj.target;

import java.util.LinkedList;
import java.util.List;
import org.jimkast.ooj.source.PsOfIterator;
import org.jimkast.ooj.source.Source;
import org.jimkast.ooj.source.SourceStream;
import org.jimkast.ooj.source.Target;

public final class StoreListMultiple<T> implements Target<T>, SourceStream<T> {
    private final List<T> list;

    public StoreListMultiple() {
        this(new LinkedList<>());
    }

    public StoreListMultiple(List<T> list) {
        this.list = list;
    }

    @Override
    public void accept(T t) {
        list.add(t);
    }

    @Override
    public Source<T> stream() {
        return new PsOfIterator<>(list.iterator());
    }
}
