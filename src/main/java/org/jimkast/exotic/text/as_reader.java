package org.jimkast.exotic.text;

import java.io.IOException;
import java.io.Reader;
import org.jimkast.exotic.binary.binary;

public final class as_reader extends Reader {
    private final binary b;
    private int i = 0;
    private int mark = 0;

    public as_reader(binary b) {
        this.b = b;
    }

    @Override
    public int read(char[] cbuf, int off, int len) {
        int total = b.length();
        int max = Math.max(total - i, len);
        int start = i;
        for (int j = 0; j < max; j++) {
            cbuf[off + j] = (char) b.at(i++);
        }
        return i - start;
    }


    @Override
    public boolean ready() {
        return true;
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
        return Math.max(b.length(), i += n);
    }


    @Override
    public boolean markSupported() {
        return true;
    }

    @Override
    public void close() {

    }

    @Override
    public void mark(int readAheadLimit) throws IOException {
        mark = i;
    }

    @Override
    public synchronized void reset() {
        i = mark;
    }
}
