package org.jimkast.ooj.heap;

import java.io.IOException;
import org.jimkast.ooj.net.OutStream;

public final class Offseted implements MemBlockR, MemBlockW {
    private final int offset;
    private final MemBlockRW origin;

    public Offseted(int offset, MemBlockRW origin) {
        this.offset = offset;
        this.origin = origin;
    }

    @Override
    public int map(int offset) {
        return origin.map(offset + this.offset);
    }

    @Override
    public void printTo(OutStream out, int offset, int length) throws IOException {
        origin.printTo(out, this.offset + offset, length);
    }

    @Override
    public int length() {
        return origin.length() - offset;
    }


    @Override
    public void write(int skip, HeapBlock block) throws IOException {
        origin.write(skip + offset, block);
    }
}
