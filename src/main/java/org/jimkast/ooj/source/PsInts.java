package org.jimkast.ooj.source;

public final class PsInts implements Source<Integer> {
    private int i;

    public PsInts() {
        this(0);
    }

    public PsInts(int i) {
        this.i = i;
    }

    @Override
    public void feed(Target<Integer> target) {
        target.accept(i++);
    }
}
