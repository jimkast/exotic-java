package org.jimkast.ooj.heap;

import java.io.IOException;
import org.jimkast.ooj.net.OutStream;

public final class HeapSliced implements MemBlockRW {
    private final byte[] jarr;
    private final int offset;
    private final int length;

    public HeapSliced(byte[] jarr, int offset, int length) {
        this.jarr = jarr;
        this.offset = offset;
        this.length = length;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public int map(int offset) {
        return jarr[offset + this.offset];
    }

    @Override
    public MemBlockRW slice(int offset, int length) {
        return new HeapSliced(jarr, offset + this.offset, length);
    }

    @Override
    public void feed(OutStream out) throws IOException {
        out.accept(jarr, offset, length);
    }

    @Override
    public void accept(byte[] b, int offset, int length) {
        System.arraycopy(b, offset, jarr, offset, length);
    }
}
