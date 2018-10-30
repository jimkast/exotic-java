package org.jimkast.ooj.source;

public final class PsForEach<T> implements Source<T> {
    private final CondSource<T> origin;

    public PsForEach(Source<T> origin) {
        this(new CondSource.Default<>(origin));
    }

    public PsForEach(CondSource<T> origin) {
        this.origin = origin;
    }

    @Override
    public void feed(Target<T> target) {
        while (origin.feed(target).choose(true, false)) ;
    }
}
