package org.jimkast.exotic.text;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.nio.charset.Charset;
import org.jimkast.exotic.binary.bconv;
import org.jimkast.exotic.binary.bconverted;
import org.jimkast.exotic.binary.binary;

public final class encoded extends binary.env {
    public encoded(Charset cs, binary origin) {
        super(new bconverted(new encoder(cs), origin));
    }

    public static final class encoder implements bconv {
        private final Charset cs;

        public encoder(Charset cs) {
            this.cs = cs;
        }

        @Override
        public binary convert(binary b) {
            int len = b.length();
            ByteArrayOutputStream out = new ByteArrayOutputStream((int) cs.newEncoder().averageBytesPerChar() * len);
            Writer writer = new OutputStreamWriter(out, cs);
            try {
                for (int i = 0; i < len; i++) {
                    writer.write(b.at(i));
                }
                writer.flush();
                return new headof(out.size(), new fixed8(out.toByteArray()));
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }
}
