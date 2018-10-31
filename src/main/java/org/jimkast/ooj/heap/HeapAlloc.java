package org.jimkast.ooj.heap;

import java.io.IOException;
import org.jimkast.ooj.net.OutStream;

public final class HeapAlloc implements MemBlockRW {
    private final byte[] jarr;

    public HeapAlloc(int size) {
        this(new byte[size]);
    }

    public HeapAlloc(byte[] jarr) {
        this.jarr = jarr;
    }

    @Override
    public int length() {
        return jarr.length;
    }

    @Override
    public int map(int offset) {
        return jarr[offset];
    }

    @Override
    public MemBlockRW slice(int offset, int length) {
        return new HeapSliced(jarr, offset, jarr.length - offset);
    }

    @Override
    public void feed(OutStream out) throws IOException {
        out.accept(jarr, 0, jarr.length);
    }

    @Override
    public void accept(byte[] b, int offset, int length) throws IOException {
        System.arraycopy(b, offset, jarr, 0, length);
    }
}
