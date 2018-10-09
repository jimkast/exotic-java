package org.jimkast.exotic.memory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.cactoos.Input;

public final class as_inputstream implements Input {
    private final memblockR block;

    public as_inputstream(memblockR block) {
        this.block = block;
    }

    @Override
    public InputStream stream() throws Exception {
        addr a = block.address();
        return new ByteArrayInputStream(a.arr, a.offset, block.length().intValue());
    }
}
