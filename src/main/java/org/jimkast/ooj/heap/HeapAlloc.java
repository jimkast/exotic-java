package org.jimkast.ooj.heap;

import java.io.IOException;
import org.jimkast.ooj.net.OutStream;

public final class HeapAlloc implements HeapBlockArray, MemBlockR, MemBlockW {
    private final byte[] jarr;

    public HeapAlloc(int size) {
        this(new byte[size]);
    }

    HeapAlloc(byte[] jarr) {
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
        out.accept(this);
    }

    @Override
    public void write(int skip, HeapBlockArray block) throws IOException {
        HeapAddr addr = block.address();
        System.arraycopy(addr.jarr, addr.offset, jarr, skip, block.length());
    }

    public void write(int skip, byte[] block, int offset, int len) throws IOException {
        System.arraycopy(block, offset, jarr, skip, len);
    }

    public void write(int skip, HeapAddr a, int len) throws IOException {
        System.arraycopy(a.jarr, a.offset, jarr, skip, len);
    }

    @Override
    public HeapAddr address() {
        return new HeapAddr(jarr);
    }
}
