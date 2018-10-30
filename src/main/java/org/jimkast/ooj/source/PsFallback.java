package org.jimkast.ooj.source;

public final class PsFallback<T> implements Source<T> {
    private final Source<T> other;
    private final CondSource<T> origin;

    public PsFallback(T fixed, Source<T> origin) {
        this(new Source.Fixed<>(fixed), origin);
    }

    public PsFallback(Source<T> other, Source<T> origin) {
        this(other, new CondSource.Default<>(origin));
    }

    public PsFallback(Source<T> other, CondSource<T> origin) {
        this.other = other;
        this.origin = origin;
    }

    @Override
    public void feed(Target<T> target) {
        origin.feed(target).choose(Source.Empty.<T>instance(), other).feed(target);
    }
}
