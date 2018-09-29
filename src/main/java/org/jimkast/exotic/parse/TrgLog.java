package org.jimkast.exotic.parse;

import java.io.IOException;
import java.io.OutputStream;

public final class TrgLog implements target {
    private final OutputStream out;

    public TrgLog() {
        this(System.out);
    }

    public TrgLog(OutputStream out) {
        this.out = out;
    }

    @Override
    public void accept(chunk ev, chunk c) throws IOException {
        ev.print(out);
        out.write(" - ".getBytes());
        c.print(out);
        out.write('\n');
    }
}
