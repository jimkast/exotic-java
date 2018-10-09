package org.jimkast.exotic.memory;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.exotic.io.bs.bsource;

public final class as_bsinput implements bsource {
    private final memblockR block;

    public as_bsinput(memblockR block) {
        this.block = block;
    }

    @Override
    public void transferTo(OutputStream out) throws IOException {
        addr a = block.address();
        out.write(a.arr, a.offset, block.length().intValue());
    }
}
