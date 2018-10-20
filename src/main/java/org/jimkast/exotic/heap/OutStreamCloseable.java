package org.jimkast.exotic.heap;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;

public interface OutStreamCloseable extends OutStream, Closeable {
    void write(HeapBlock heap) throws IOException;


    final class AsCloseable implements OutStreamCloseable {
        private final OutStream out;

        public AsCloseable(OutStream out) {
            this.out = out;
        }

        @Override
        public void write(HeapBlock heap) throws IOException {
            out.write(heap);
        }

        @Override
        public void close() {
        }
    }


    final class AsOutputStream extends OutputStream {
        private final byte[] buf = new byte[1];
        private final OutStreamCloseable out;

        public AsOutputStream(OutStream out) {
            this(new AsCloseable(out));
        }

        public AsOutputStream(OutStreamCloseable out) {
            this.out = out;
        }

        @Override
        public void write(int b) throws IOException {
            buf[0] = (byte) b;
            write(buf);
        }

        @Override
        public void write(byte[] block, int offset, int len) throws IOException {
            out.write(new HeapFixed(block, offset, len));
        }

        @Override
        public void close() throws IOException {
            out.close();
        }
    }
}
