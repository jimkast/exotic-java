package org.jimkast.exotic.string;

import java.util.List;

public final class Concat implements Readable {
    private final List<Readable> all;

    public Concat(List<Readable> all) {
        this.all = all;
    }

    @Override
    public int at(int i) {
        return slice(i, 1).at(0);
    }

    @Override
    public int length() {
        int l = 0;
        for (Readable s : all) {
            l += s.length();
        }
        return l;
    }

    @Override
    public Readable slice(int offset, int length) {
        int count = 0;
        for (Readable s : all) {
            count += s.length();
            if (offset < count) {
                return s.slice(count - offset, length);
            }
        }
        throw new IndexOutOfBoundsException("For index " + offset);
    }

    @Override
    public void transferTo(Writeable out) {
        for (Readable r : all) {
            r.transferTo(out);
        }
    }
}
