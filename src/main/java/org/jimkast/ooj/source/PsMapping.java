package org.jimkast.ooj.source;

import org.jimkast.ooj.map.Mapping;

public final class PsMapping<T> implements Source<T> {
    private final Mapping<Target<T>, Source<T>> mapping;

    public PsMapping(Mapping<Target<T>, Source<T>> mapping) {
        this.mapping = mapping;
    }

    @Override
    public void feed(Target<T> target) {
        mapping.map(target).feed(target);
    }
}
