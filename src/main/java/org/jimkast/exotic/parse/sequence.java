package org.jimkast.exotic.parse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public final class sequence implements scanned_source {
    private final Iterable<scanned_source> all;

    public sequence(scanned_source... all) {
        this(Arrays.asList(all));
    }

    public sequence(Iterable<scanned_source> all) {
        this.all = all;
    }

    @Override
    public void consume(Scanner scanner) throws IOException {
        for (scanned_source s : all) {
            s.consume(scanner);
        }
    }
}
