package org.jimkast.exotic.binary;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.exotic.io.bs.bsource;

public final class filtered implements bstreamable, bsource {
    private final bfilter filter;
    private final binary origin;

    public filtered(bfilter filter, binary origin) {
        this.filter = filter;
        this.origin = origin;
    }

    @Override
    public bstream stream() {
        return new filtered_stream(filter, origin);
    }

    @Override
    public void transferTo(OutputStream out) throws IOException {
        int len = origin.length();
        for (int i = 0; i < len; i++) {
            int b = origin.map(i);
            if (filter.test(b)) {
                out.write(b);
            }
        }
    }

    public static final class filtered_stream implements bstream {
        private final bfilter filter;
        private final binary origin;
        private int i = 0;

        public filtered_stream(bfilter filter, binary origin) {
            this.filter = filter;
            this.origin = origin;
        }

        @Override
        public int read() {
            int len = origin.length();
            while (i < len) {
                int b = origin.map(i++);
                if (filter.test(b)) {
                    return b;
                }
            }
            return -1;
        }
    }
}
