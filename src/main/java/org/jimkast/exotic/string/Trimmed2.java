package org.jimkast.exotic.string;

public final class Trimmed2 implements Readable {
    private final Number skip;
    private final Readable origin;

    public Trimmed2(Number skip, Readable origin) {
        this.skip = skip;
        this.origin = origin;
    }

    @Override
    public int at(int i) {
        return 0;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public Readable slice(int offset, int length) {
        return null;
    }

    @Override
    public void transferTo(Writeable out) {

    }
}
