package org.jimkast.exotic.io.bs;

import java.io.IOException;
import java.io.OutputStream;
import java.util.function.Function;

public final class bsmapped implements BytesSource {
    private final Function<OutputStream, OutputStream> mapper;
    private final BytesSource origin;

    public bsmapped(Function<OutputStream, OutputStream> mapper, BytesSource origin) {
        this.mapper = mapper;
        this.origin = origin;
    }

    @Override
    public void print(OutputStream out) throws IOException {
        origin.print(mapper.apply(out));
    }
}
