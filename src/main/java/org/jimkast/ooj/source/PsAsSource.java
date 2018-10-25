package org.jimkast.ooj.source;

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
