package org.jimkast.exotic.text;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.io.bs.bsource;

public final class bstream_1by1 implements bsource {
    private final binary origin;

    public bstream_1by1(binary origin) {
        this.origin = origin;
    }

    @Override
    public void transferTo(OutputStream out) throws IOException {
        int len = origin.length();
        for (int i = 0; i < len; i++) {
            out.write(origin.map(i));
        }
    }
}
