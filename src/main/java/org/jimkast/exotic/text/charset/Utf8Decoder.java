package org.jimkast.exotic.text.charset;

import java.io.IOException;
import org.jimkast.exotic.binary.bstream;

public final class Utf8Decoder implements CsCodec {
    private static final int MASK = 0b00111111;

    @Override
    public int consume(bstream stream) throws IOException {
        int b = stream.read();
        if (b == -1) {
            return -1;
        }
        if (b < 0b10000000) {
            return b;
        }
        if (b < 0b11100000) {
            return (b & 0b00011111) << 6 | (stream.read() & MASK);
        }
        if (b < 0b11110000) {
            return (b & 0b00001111) << 12 | (stream.read() & MASK) << 6 | (stream.read() & MASK);
        }
        return (b & 0b00000111) << 18 | (stream.read() & MASK) << 12 | (stream.read() & MASK) << 6 | (stream.read() & MASK);
    }

//    public static int byteArrayToInt(byte[] b) {
//        return b[3] & 0xFF |
//            (b[2] & 0xFF) << 8 |
//            (b[1] & 0xFF) << 16 |
//            (b[0] & 0xFF) << 24;
//    }
//
//    public static byte[] intToByteArray(int a) {
//        return new byte[]{
//            (byte) ((a >> 24) & 0xFF),
//            (byte) ((a >> 16) & 0xFF),
//            (byte) ((a >> 8) & 0xFF),
//            (byte) (a & 0xFF)
//        };
//    }
}
