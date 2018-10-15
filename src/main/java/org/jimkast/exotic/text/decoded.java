package org.jimkast.exotic.text;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import org.cactoos.Input;
import org.jimkast.exotic.binary.binary;

public final class decoded implements Input {
    private final Charset cs;
    private final binary b;

    public decoded(Charset cs, binary b) {
        this.cs = cs;
        this.b = b;
    }

    @Override
    public InputStream stream() {
        return new InReader(new InputStreamReader(new as_bytestream(b), cs));
    }


    public static final class InReader extends InputStream {
        private final Reader reader;

        public InReader(Reader reader) {
            this.reader = reader;
        }

        @Override
        public int read() throws IOException {
            return reader.read();
        }

        @Override
        public long skip(long n) throws IOException {
            return reader.skip(n);
        }

        @Override
        public boolean markSupported() {
            return reader.markSupported();
        }

        @Override
        public void reset() throws IOException {
            reader.reset();
        }

        @Override
        public void close() throws IOException {
            reader.close();
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }
    }
}
