package org.jimkast.ooj.source;

public final class PsWithFixedTarget<T> implements Source<T> {
    private final Target<T> target;
    private final Source<T> source;

    public PsWithFixedTarget(Target<T> target, Source<T> source) {
        this.target = target;
        this.source = source;
    }

    @Override
    public void feed(Target<T> target) {
        source.feed(this.target);
    }
}
