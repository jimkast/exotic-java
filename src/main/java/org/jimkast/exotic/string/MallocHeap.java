package org.jimkast.exotic.string;

import java.io.IOException;
import org.jimkast.exotic.net.OutStream;

public final class MallocHeap implements MemBlockR, MemBlockW {
    private final byte[] jarr;

    public MallocHeap(int size) {
        this(new byte[size]);
    }

    MallocHeap(byte[] jarr) {
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
    public void printTo(OutStream out, int offset, int length) throws IOException {
        out.write(jarr, offset, length);
    }

    @Override
    public void write(int skip, byte[] block, int offset, int len) throws IOException {
        System.arraycopy(block, offset, jarr, skip, len);

    }
}
