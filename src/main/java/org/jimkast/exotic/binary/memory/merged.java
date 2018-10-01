package org.jimkast.exotic.binary.memory;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import org.jimkast.exotic.Native;

@Native
public final class merged implements memblock {
    private final byte[] address;
    private final int offset;
    private final int length;

    public merged(byte[] address, int offset, int length) {
        this.address = address;
        this.offset = offset;
        this.length = length;
    }

    @Override
    public int at(int i) {
        return address[offset + i];
    }

    @Override
    public void put(int i, byte b) {
        address[i] = b;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public memblock resize(Number offset, Number length) {
        final memblock result;
        int off = offset.intValue();
        int len = length.intValue();
        int diff = off + len - this.length;
        Arrays.copyOf(address, 100)
        if (diff == 0) {
            result = this;
        } else if (diff < 0) {
            result = new merged(address, off, len);
        } else {
            result = new merged(Arrays.copyOfRange(address, off, off + len), 0, 0);
        }
        return result;
    }

    @Override
    public void transferTo(OutputStream out) throws IOException {
        out.write(address, offset, length);
    }
}
