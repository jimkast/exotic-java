package org.jimkast.ooj.net;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;

public interface OutStreamCloseable extends OutStream, Closeable {

    final class AsCloseable implements OutStreamCloseable {
        private final OutStream out;

        public AsCloseable(OutStream out) {
            this.out = out;
        }

        @Override
        public void accept(byte[] b, int offset, int length) throws IOException {
            out.accept(b, offset, length);
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
            out.accept(block, offset, len);
        }

        @Override
        public void close() throws IOException {
            out.close();
        }
    }


    final class Of implements OutStreamCloseable {
        private final OutputStream out;

        public Of(OutputStream out) {
            this.out = out;
        }

        @Override
        public final void accept(byte[] b, int offset, int length) throws IOException {
            out.write(b, offset, length);
        }

        @Override
        public void close() throws IOException {
            out.close();
        }
    }
}
