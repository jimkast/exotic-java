package org.jimkast.exotic.text;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.io.bs.bsource;

public final class encoded implements bsource {
    private final Charset cs;
    private final bsource origin;

    public encoded(Charset cs, binary origin) {
        this(cs, new bstream_1by1(origin));
    }

    public encoded(Charset cs, bsource origin) {
        this.cs = cs;
        this.origin = origin;
    }

    @Override
    public void transferTo(OutputStream out) throws IOException {
        OutputStream str = new OutWriter(new OutputStreamWriter(out, cs));
        origin.transferTo(str);
        str.flush();
    }


    public static final class OutWriter extends OutputStream {
        private final Writer writer;

        public OutWriter(Writer writer) {
            this.writer = writer;
        }

        @Override
        public void write(int b) throws IOException {
            writer.write(b);
        }

        @Override
        public void close() throws IOException {
            writer.flush();
            writer.close();
        }

        @Override
        public void flush() throws IOException {
            writer.flush();
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }
    }
}
