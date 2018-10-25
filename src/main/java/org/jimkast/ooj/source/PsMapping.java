package org.jimkast.ooj.source;

import org.jimkast.ooj.lang.Cond;
import org.jimkast.ooj.lang.Mapping;
import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.lang.Target;

public final class PsMapping<T> implements PSource<T> {
    private final Mapping<Target<T>, PSource<T>> mapping;

    public PsMapping(Mapping<Target<T>, PSource<T>> mapping) {
        this.mapping = mapping;
    }

    @Override
    public Cond feed(Target<T> target) {
        return mapping.map(target).feed(target);
    }
}
