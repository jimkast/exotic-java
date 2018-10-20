package org.jimkast.exotic.string;

import java.io.IOException;
import org.jimkast.exotic.net.OutStream;

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
    public void write(int skip, byte[] block, int offset, int len) throws IOException {
        origin.write(skip + offset, block, offset, len);
    }
}
