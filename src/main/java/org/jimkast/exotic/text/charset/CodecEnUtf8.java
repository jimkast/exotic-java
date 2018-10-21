package org.jimkast.exotic.text.charset;

import java.io.IOException;
import org.jimkast.exotic.binary.bstream;

public final class CodecEnUtf8 implements CsCodec {
    private int buf = 0;
    private int remaining = 0;

    @Override
    public int consume(bstream stream) throws IOException {
        if (remaining == 0) {
            buf = stream.read();
        }
        int b = stream.read();
        if (b < 0x0080) {
            remaining = 1;
        } else if (b < 0x0800) {
            remaining = 2;
        } else if (b <= 0xffff) {
            remaining = 3;
        } else {
            remaining = 4;
        }
        return (buf >> (remaining-- * 8)) & 0xFF;
    }
}
