package org.jimkast.ooj.bisource;

public final class PsBiForEach<X, Y> implements BiSource<X, Y> {
    private final BiCondSource<X, Y> origin;

    public PsBiForEach(BiSource<X, Y> origin) {
        this(new BiCondSource.Default<>(origin));
    }

    public PsBiForEach(BiCondSource<X, Y> origin) {
        this.origin = origin;
    }

    @Override
    public void feed(BiTarget<X, Y> target) {
        while (origin.feed(target).choose(true, false)) ;
    }
}
