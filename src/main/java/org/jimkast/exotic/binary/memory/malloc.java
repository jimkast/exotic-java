package org.jimkast.exotic.binary.memory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import org.cactoos.Input;
import org.jimkast.exotic.Native;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.io.bs.bsource;

@Native
public final class malloc implements memblock3, memblock, binary, bsource, bout, Input {
    private final byte[] address;
    private final int offset;
    private final int length;

    public malloc(int size) {
        this(new byte[size]);
    }

    public malloc(byte[] address) {
        this(address, 0);
    }

    public malloc(byte[] address, int offset) {
        this(address, offset, address.length);
    }

    public malloc(byte[] address, int offset, int length) {
        this.address = address;
        this.offset = offset;
        this.length = length;
    }

    @Override
    public int at(int i) {
        return address[offset + i];
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public void put(int i, byte b) {
        address[i] = b;
    }

    @Override
    public malloc replace(int offset, memblock3 bytes) {
        malloc m = bytes.bytes();
        int diff = length - offset - this.offset - m.length;
        if (m.length() == 0) {

        }
        return new malloc(
            Arrays.copyOfRange(address, off, off + len));
        )
    }

    @Override
    public malloc resize(Number offset, Number length) {
        final malloc result;
        int off = offset.intValue();
        int len = length.intValue();
        int diff = off + len - this.length;
        if (diff == 0) {
            result = this;
        } else if (diff < 0) {
            result = new malloc(address, off, len);
        } else {
            result = new malloc(Arrays.copyOfRange(address, off, off + len));
        }
        return result;
    }

    @Override
    public void transferTo(OutputStream out) throws IOException {
        out.write(address, offset, length);
    }

    @Override
    public malloc bytes() {
        return this;
    }

    @Override
    public InputStream stream() {
        return new ByteArrayInputStream(address, offset, length);
    }
}
