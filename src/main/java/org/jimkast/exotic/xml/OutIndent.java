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
        boolean closing = false;
        if (b == '>' && (last == '-' || last == '/')) {
            depth--;
            last_opened = false;
            origin.write(b);
        } else if (b == '<') {
            gtbuf = true;
        } else if (gtbuf) {
            if (b == '/') {
                depth--;
                closing = true;
            } else {
                last_opened = true;
                depth++;
            }
            if(last_opened || !closing) {
                origin.write('\n');
                for (int i = 0; i < depth; i++) {
                    sep.transferTo(origin);
                }
            } else {
                last_opened = true;
            }
            origin.write('<');
            origin.write(b);
            gtbuf = false;
        } else {
            origin.write(b);
        }
        last = b;
    }


    @Override
    public void flush() throws IOException {
        origin.flush();
    }

    @Override
    public void close() throws IOException {
        origin.close();
    }
}
