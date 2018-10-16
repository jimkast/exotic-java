package org.jimkast.exotic.text;

import java.io.InputStream;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.binary.bstream;

public final class as_bytestream extends InputStream implements bstream {
    private final binary b;
    private int i = 0;
    private int mark = 0;

    public as_bytestream(binary b) {
        this.b = b;
    }

    @Override
    public int read() {
        if (i >= b.length()) {
            return -1;
        }
        return b.at(i++);
    }

    @Override
    public long skip(long n) {
        return i += n;
    }

    @Override
    public synchronized void mark(int readlimit) {
        mark = i;
    }

    @Override
    public boolean markSupported() {
        return true;
    }

    @Override
    public void close() {

    }

    @Override
    public synchronized void reset() {
        i = mark;
    }

    @Override
    public int available() {
        return b.length();
    }
}
