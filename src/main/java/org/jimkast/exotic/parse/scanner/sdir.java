package org.jimkast.exotic.parse.scanner;

import java.io.IOException;
import java.util.Scanner;
import org.jimkast.exotic.parse.chunk;
import org.jimkast.exotic.parse.scanned_source;
import org.jimkast.exotic.parse.target;

public final class sdir implements scanned_source {
    private final chunk ev;
    private final dir d;
    private final target t;

    public sdir(String ev, dir d, target t) {
        this(new chunk.str(ev), d, t);
    }

    public sdir(chunk ev, dir d, target t) {
        this.ev = ev;
        this.t = t;
        this.d = d;
    }

    @Override
    public void consume(Scanner scanner) throws IOException {
        t.accept(ev, d.next(scanner));
    }
}
