package org.jimkast.ooj.bisource;

import org.jimkast.ooj.map.BiMapping;
import org.jimkast.ooj.source.Source;
import org.jimkast.ooj.source.Target;

public final class PsReduced<T> implements Source<T> {
    private final BiMapping<T, T, T> mapping;
    private final BiSource<T, T> origin;

    public PsReduced(T init, BiMapping<T, T, T> mapping, Source<T> origin) {
        this(mapping, new BiPs2<>(init, origin));
    }

    public PsReduced(BiMapping<T, T, T> mapping, BiSource<T, T> origin) {
        this.mapping = mapping;
        this.origin = origin;
    }

    @Override
    public void feed(Target<T> target) {
        origin.feed((t, t2) -> target.accept(mapping.map(t, t2)));
    }
}
