package org.jimkast.exotic.text.charset;

import java.io.IOException;
import org.jimkast.exotic.binary.bstream;

public final class CodecStream implements bstream {
    private final CsCodec codec;
    private final bstream origin;

    public CodecStream(CsCodec codec, bstream origin) {
        this.codec = codec;
        this.origin = origin;
    }

    @Override
    public int read() throws IOException {
        return codec.consume(origin);
    }
}
