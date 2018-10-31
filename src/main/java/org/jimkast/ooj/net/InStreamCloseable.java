package org.jimkast.ooj.net;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public interface InStreamCloseable extends InStream, Closeable {

    final class AsCloseable implements InStreamCloseable {
        private final InStream in;

        public AsCloseable(InStream in) {
            this.in = in;
        }

        @Override
        public int read(byte[] b, int offset, int length) throws IOException {
            return in.read(b, offset, length);
        }

        @Override
        public void close() {
        }
    }


    final class AsInputStream extends InputStream {
        private final byte[] buf = new byte[1];
        private final InStreamCloseable in;

        public AsInputStream(InStream out) {
            this(new AsCloseable(out));
        }

        public AsInputStream(InStreamCloseable out) {
            this.in = out;
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

        @Override
        public void close() throws IOException {
            in.close();
        }
    }
}
