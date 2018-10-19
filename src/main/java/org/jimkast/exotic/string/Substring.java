package org.jimkast.exotic.string;

public final class Substring implements Readable {
    private final int length;
    private final Readable r;

    public Substring(int length, Readable r) {
        this.length = length;
        this.r = r;
    }

    @Override
    public int at(int i) {
        return r.at(i);
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public void transferTo(Writeable out) {
        r.slice(0, length).transferTo(out);
    }

    @Override
    public Readable slice(int offset, int length) {
        return r.slice(offset, Math.max(length, this.length));
    }
}
