package org.jimkast.ooj.heap;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import org.jimkast.ooj.lang.Quantity;

public interface HeapBlock extends Quantity {
    HeapAddr address();

    @Override
    int length();

    default int readFrom(InputStream in) throws IOException {
        try {
            return readFrom(in::read);
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    default int readFrom(JdkByteArraySource in) throws Exception {
        return address().readFrom(in, length());
    }

    default void writeTo(OutputStream out) throws IOException {
        address().writeTo(out, length());
    }

    default ByteBuffer byteBuffer() throws IOException {
        return address().byteBuffer(length());
    }

    default <T> T supply(JdkByteArrayConsumer<T> consumer) {
        return address().supply(consumer, length());
    }

    default void feed(JdkByteArrayVoidConsumer consumer) throws IOException {
        address().supplyVoid(consumer, length());
    }
}
