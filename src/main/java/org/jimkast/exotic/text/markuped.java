//package org.jimkast.exotic.text;
//
//import java.io.IOException;
//import java.io.InputStream;
//import org.jimkast.exotic.binary.binary;
//
//public final class markuped extends InputStream {
//    private final binary origin;
//    private final binary markup;
//    private final int from;
//    private final int to;
//    private int i = 0;
//    private InputStream cur = new as_bytestream(origin);
//
//    public markuped(binary origin, binary markup, int from, int to) {
//        this.origin = origin;
//        this.markup = markup;
//        this.from = from;
//        this.to = to;
//        // 12345 /bookings w345tsets
//        /*
//1235 <uri>/bookings</uri> w345tsets
//         */
//        // from: 6, to: 15
//    }
//
//    @Override
//    public int read() throws IOException {
//        int r;
//        int mlen = markup.length();
//        if (i < from) {
//            r = origin.at(i);
//        } else if (i == from || i == to + mlen + 2) {
//            r = '<';
//        } else if (i == to + mlen + 3) {
//            r = '/';
//        } else if (i == from + mlen + 1 || i == to + mlen + 2) {
//            r = '>';
//        } else if (i <= from + mlen) {
//            r = markup.at(i - from);
//        } else if (i <= to + mlen) {
//            r = origin.at(i + mlen + 1);
//        } else if (i <= to + mlen) {
//            r = origin.at(i + mlen + 1);
//        } else {
//            r = -1;
//        }
//        return r;
//    }
//}
