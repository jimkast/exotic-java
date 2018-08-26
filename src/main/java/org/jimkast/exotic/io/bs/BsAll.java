package org.jimkast.exotic.io.bs;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public final class BsAll implements BytesSource {
    private final Iterable<BytesSource> all;

    public BsAll(BytesSource... all) {
        this(Arrays.asList(all));
    }

    public BsAll(Iterable<BytesSource> all) {
        this.all = all;
    }

    @Override
    public void print(OutputStream out) throws IOException {
        for (BytesSource source : all) {
            source.print(out);
        }
    }
}
