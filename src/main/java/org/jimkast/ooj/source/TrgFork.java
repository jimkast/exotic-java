package org.jimkast.ooj.source;

import org.jimkast.ooj.map.Choose;
import org.jimkast.ooj.map.Mapping;
import org.jimkast.ooj.map.PMapping;

public final class TrgFork<T> implements Target<T> {
    private final Mapping<T, Target<T>> mapping;

    @SafeVarargs
    public TrgFork(PMapping<T, Target<T>>... mappings) {
        this(Target.Noop.instance(), mappings);
    }

    @SafeVarargs
    public TrgFork(Target<T> def, PMapping<T, Target<T>>... mappings) {
        this(new Choose<>(def, mappings));
    }

    public TrgFork(Mapping<T, Target<T>> mapping) {
        this.mapping = mapping;
    }

    @Override
    public void accept(T t) {
        mapping.map(t).accept(t);
    }
}
