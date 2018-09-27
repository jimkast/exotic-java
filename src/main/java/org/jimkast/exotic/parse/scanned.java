package org.jimkast.exotic.parse;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public final class scanned implements source {
    private final scanned_source s;

    public scanned(scanned_source s) {
        this.s = s;
    }

    @Override
    public void consume(InputStream is) throws IOException {
        s.consume(new Scanner(is));
    }
}
