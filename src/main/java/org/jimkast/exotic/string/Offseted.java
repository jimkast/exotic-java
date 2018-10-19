package org.jimkast.exotic.string;

public final class Offseted implements Readable {
    private final int offset;
    private final Readable r;

    public Offseted(int offset, Readable r) {
        this.offset = offset;
        this.r = r;
    }

    @Override
    public int at(int i) {
        return r.at(i + offset);
    }

    @Override
    public int length() {
        return r.length() - offset;
    }

    @Override
    public Readable slice(int offset, int length) {
        return r.slice(offset + this.offset, length);
    }

    @Override
    public void transferTo(Writeable out) {
        r.slice(this.offset, length() - this.offset).transferTo(out);
    }
}
