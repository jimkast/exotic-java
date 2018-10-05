package org.jimkast.exotic.xml;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.exotic.io.bs.bsource;

public final class OutIndent extends OutputStream {
    private final bsource sep;
    private final OutputStream origin;
    private int depth = 0;
    private int last = 0;
    private boolean last_opened = false;
    private boolean gtbuf = false;

    public OutIndent(OutputStream origin) {
        this(new bsource.Const(new byte[]{' ', ' ', ' ', ' '}), origin);
    }

    public OutIndent(bsource sep, OutputStream origin) {
        this.sep = sep;
        this.origin = origin;
    }

    @Override
    public void write(int b) throws IOException {
        if (b == '<') {
            gtbuf = true;
            return;
        }
        boolean self_closing = false;
        boolean closing = false;
        boolean opening = false;
        if (b == '>' && (last == '-' || last == '/')) {
            self_closing = true;
        } else if (gtbuf) {
            gtbuf = false;
            if (b == '/') {
                closing = true;
            } else {
                opening = true;
            }
            gtbuf = false;
        }
        if (opening || closing && !last_opened) {
            int dep = closing ? depth - 1 : depth;
            origin.write('\n');
            for (int i = 0; i < dep; i++) {
                sep.transferTo(origin);
            }
        }
        if (opening || closing) {
            origin.write('<');
        }
        origin.write(b);
        if (opening) {
            depth++;
            last_opened = true;
        } else if (self_closing || closing) {
            depth--;
            last_opened = false;
        }
        last = b;
    }


    @Override
    public void flush() throws IOException {
        origin.flush();
        if (gtbuf) {
            origin.write('<');
        }
    }

    @Override
    public void close() throws IOException {
        origin.close();
    }
}
