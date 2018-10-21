package org.jimkast.exotic.heap;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import org.jimkast.exotic.Native;

@Native
public final class HeapAddr {
    final byte[] jarr;
    final int offset;

    HeapAddr(byte[] jarr) {
        this(jarr, 0);
    }

    public HeapAddr(byte[] jarr, int offset) {
        this.jarr = jarr;
        this.offset = offset;
    }

    public int readFrom(InputStream in, int length) throws IOException {
        return in.read(jarr, offset, length);
    }

    public void writeTo(OutputStream out, int length) throws IOException {
        out.write(jarr, offset, length);
    }

    public ByteBuffer buffer(int length) {
        return ByteBuffer.wrap(jarr, offset, length);
    }

    public <T> T supply(JdkByteArrayConsumer<T> consumer, int length) {
        return consumer.accept(jarr, offset, length);
    }
}
