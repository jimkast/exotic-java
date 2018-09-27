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
    public void accept(String ev, chunk c) throws IOException {
        out.write(ev.getBytes());
        out.write(" - ".getBytes());
        c.print(out);
        out.write('\n');
    }
}
