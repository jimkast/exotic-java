package org.jimkast.exotic.net;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public interface InStream extends Closeable {
    int read(byte[] block, int offset, int len) throws IOException;

    final class AsInputStream extends InputStream {
        private final byte[] buf = new byte[1];
        private final InStream in;

        public AsInputStream(InStream in) {
            this.in = in;
        }

        @Override
        public int read() throws IOException {
            int res = read(buf);
            return res == -1 ? res : buf[0];
        }

        @Override
        public int read(byte[] block, int offset, int len) throws IOException {
            return in.read(block, offset, len);
        }
    }
}
