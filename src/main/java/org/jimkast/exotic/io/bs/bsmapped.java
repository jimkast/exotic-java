package org.jimkast.exotic.io.bs;

import java.io.IOException;
import java.io.OutputStream;
import java.util.function.Function;

public final class bsmapped implements bsource {
    private final Function<OutputStream, OutputStream> mapper;
    private final bsource origin;

    public bsmapped(Function<OutputStream, OutputStream> mapper, bsource origin) {
        this.mapper = mapper;
        this.origin = origin;
    }

    @Override
    public void transferTo(OutputStream out) throws IOException {
        origin.transferTo(mapper.apply(out));
    }
}
