package org.jimkast.ooj.source;

public final class PsTee<T> implements Source<T> {
    private final Target<T> output;
    private final Source<T> origin;

    public PsTee(Store<T> output, Source<T> origin) {
        this.output = output;
        this.origin = origin;
    }

    @Override
    public void feed(Target<T> target) {
        origin.feed(new Target.Both<>(target, output));
    }
}
