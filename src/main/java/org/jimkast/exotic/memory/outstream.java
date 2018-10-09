package org.jimkast.exotic.memory;

import java.io.IOException;
import java.io.OutputStream;

public interface outstream {
    void write(memblockR m) throws IOException;

    void flush() throws IOException;

    void close() throws IOException;


    final class Of implements outstream {
        private final OutputStream out;

        public Of(OutputStream out) {
            this.out = out;
        }

        @Override
        public void write(memblockR m) throws IOException {
            addr a = m.address();
            out.write(a.arr, a.offset, m.length().intValue());
        }

        @Override
        public void flush() throws IOException {
            out.flush();
        }

        @Override
        public void close() throws IOException {
            out.close();
        }
    }


    final class As extends OutputStream {
        private final outstream out;

        public As(outstream out) {
            this.out = out;
        }

        @Override
        public void write(byte[] b) throws IOException {
            out.write(new malloc(b));
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            out.write(new with_length(len, new offsetted(off, new malloc(b))));
        }

        @Override
        public void write(int b) throws IOException {
            out.write(new malloc(new byte[]{(byte) b}));
        }

        @Override
        public void flush() throws IOException {
            out.flush();
        }

        @Override
        public void close() throws IOException {
            out.close();
        }
    }
}
