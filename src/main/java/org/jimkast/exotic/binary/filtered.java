package org.jimkast.exotic.binary;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.exotic.io.bs.bsource;

public final class filtered implements bsource {
    private final bfilter filter;
    private final binary origin;

    public filtered(bfilter filter, binary origin) {
        this.filter = filter;
        this.origin = origin;
    }

    @Override
    public void transferTo(OutputStream out) throws IOException {
        int len = origin.length();
        for (int i = 0; i < len; i++) {
            int b = origin.at(i);
            if (filter.test(b)) {
                out.write(b);
            }
        }
    }
}
