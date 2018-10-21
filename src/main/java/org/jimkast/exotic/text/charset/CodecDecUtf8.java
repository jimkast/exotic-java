package org.jimkast.exotic.text.charset;

import java.io.IOException;
import org.jimkast.exotic.binary.bstream;

public final class CodecDecUtf8 implements CsCodec {
    @Override
    public int consume(bstream stream) throws IOException {
        int b = stream.read();
        if (b == -1) {
            return -1;
        }
        if (b < 0x80) {
            return b;
        }
        byte[] buf = new byte[4];
        if (b < 0x800) {
            buf[2] = (byte) b;
            buf[3] = (byte) stream.read();
        } else if (b <= 0xFFFF) {
            buf[1] = (byte) b;
            buf[2] = (byte) stream.read();
            buf[3] = (byte) stream.read();
        } else {
            buf[0] = (byte) b;
            buf[1] = (byte) stream.read();
            buf[2] = (byte) stream.read();
            buf[3] = (byte) stream.read();
        }
        return byteArrayToInt(buf);
    }

    public static int byteArrayToInt(byte[] b) {
        return b[3] & 0xFF |
            (b[2] & 0xFF) << 8 |
            (b[1] & 0xFF) << 16 |
            (b[0] & 0xFF) << 24;
    }

    public static byte[] intToByteArray(int a) {
        return new byte[]{
            (byte) ((a >> 24) & 0xFF),
            (byte) ((a >> 16) & 0xFF),
            (byte) ((a >> 8) & 0xFF),
            (byte) (a & 0xFF)
        };
    }
}
