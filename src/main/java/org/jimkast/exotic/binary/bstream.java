package org.jimkast.exotic.binary;

import java.io.IOException;
import java.util.Iterator;

public interface bstream {
    int read() throws IOException;

    final class All implements bstream {
        private final Iterator<bstream> iter;
        private final int eof;
        private bstream cur;
        private int last;

        public All(Iterator<bstream> iter) {
            this(-1, iter);
        }

        public All(int eof, Iterator<bstream> iter) {
            this.iter = iter;
            this.eof = eof;
            this.last = eof;
        }

        @Override
        public int read() throws IOException {
            if (last == eof) {
                if (!iter.hasNext()) {
                    return -1;
                }
                cur = iter.next();
            }
            return last = cur.read();
        }
    }
}
