package org.jimkast.ooj.net;

import java.io.IOException;

public final class BsInput implements ByteSource {
    private final InStream in;
    private final byte[] buf;
    private final int offset;
    private final int length;

    public BsInput(InStream in) {
        this(in, 8192);
    }

    public BsInput(InStream in, int size) {
        this(in, new byte[size]);
    }

    public BsInput(InStream in, byte[] buf) {
        this(in, buf, 0, buf.length);
    }

    public BsInput(InStream in, byte[] buf, int offset, int length) {
        this.in = in;
        this.buf = buf;
        this.offset = offset;
        this.length = length;
    }

    @Override
    public void feed(OutStream out) throws IOException {
        int count;
        while ((count = in.read(buf, offset, length)) != -1) {
            out.accept(buf, offset, count);
        }
    }
}
