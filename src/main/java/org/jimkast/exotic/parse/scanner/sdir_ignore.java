package org.jimkast.exotic.parse.scanner;

import java.io.IOException;
import java.util.Scanner;
import org.jimkast.exotic.parse.scanned_source;

public final class sdir_ignore implements scanned_source {
    private final dir d;

    public sdir_ignore(dir d) {
        this.d = d;
    }


    @Override
    public void consume(Scanner scanner) throws IOException {
        d.next(scanner);
    }
}
