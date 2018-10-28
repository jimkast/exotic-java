package org.jimkast.ooj.bisource;

import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.map.BiMapping;
import org.jimkast.ooj.source.PSource;
import org.jimkast.ooj.source.Target;

public final class BiPsReduced<T> implements PSource<T> {
    private final BiMapping<T, T, T> mapping;
    private final BiPSource<T, T> origin;

    public BiPsReduced(T init, BiMapping<T, T, T> mapping, PSource<T> origin) {
        this(mapping, new BiPs2<>(init, origin));
    }

    public BiPsReduced(BiMapping<T, T, T> mapping, BiPSource<T, T> origin) {
        this.mapping = mapping;
        this.origin = origin;
    }

    @Override
    public Cond feed(Target<T> target) {
        return origin.feed((t, t2) -> target.accept(mapping.map(t, t2)));
    }
}
