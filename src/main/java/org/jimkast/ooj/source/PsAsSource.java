package org.jimkast.ooj.source;

import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.lang.Source;
import org.jimkast.ooj.lang.Target;

public final class PsAsSource<T> implements Source<T> {
    private final PSource<T> psource;

    public PsAsSource(PSource<T> psource) {
        this.psource = psource;
    }

    @Override
    public void feed(Target<T> target) {
        psource.feed(target);
    }
}
