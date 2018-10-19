package org.jimkast.exotic.net;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;

public interface OutStream extends Closeable {
    void write(byte[] block, int offset, int len) throws IOException;


    final class AsOutputStream extends OutputStream {
        private final byte[] buf = new byte[1];
        private final OutStream out;

        public AsOutputStream(OutStream out) {
            this.out = out;
        }

        @Override
        public void write(int b) throws IOException {
            buf[0] = (byte) b;
            write(buf);
        }

        @Override
        public void write(byte[] block, int offset, int len) throws IOException {
            out.write(block, offset, len);
        }
    }
}
