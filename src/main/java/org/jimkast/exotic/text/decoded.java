package org.jimkast.exotic.text;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.util.function.Function;
import org.jimkast.exotic.binary.bconv;
import org.jimkast.exotic.binary.bconverted;
import org.jimkast.exotic.binary.binary;

public final class decoded extends binary.env {
    public decoded(Charset cs, binary origin) {
        super(new bconverted(new decoder(cs), origin));
    }

    public static final class decoder implements bconv {
        private final Function<binary, Reader> mapping;

        public decoder(Charset cs) {
            this(b -> new InputStreamReader(new as_bytestream(b), cs));
        }

        public decoder(Function<binary, Reader> mapping) {
            this.mapping = mapping;
        }

        @Override
        public binary convert(binary b) {
            try {
                char[] buf = new char[b.length()];
                return new headof(mapping.apply(b).read(buf), new fixed16(buf));
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }
}
