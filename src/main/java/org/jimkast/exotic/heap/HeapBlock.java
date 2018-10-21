package org.jimkast.exotic.heap;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public interface HeapBlock extends Countable {
    HeapAddr address();

    @Override
    int length();

    default int readFrom(InputStream in) throws IOException {
        return address().readFrom(in, length());
    }

    default void writeTo(OutputStream out) throws IOException {
        address().writeTo(out, length());
    }

    default ByteBuffer buffer() throws IOException {
        return address().buffer(length());
    }

    default <T> T supply(JdkByteArrayConsumer<T> consumer) {
        return address().supply(consumer, length());
    }
}
