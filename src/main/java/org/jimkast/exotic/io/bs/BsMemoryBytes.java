package org.jimkast.exotic.io.bs;

import java.io.ByteArrayOutputStream;
import org.cactoos.Bytes;

public final class BsMemoryBytes implements Bytes {
    private final bsource source;

    public BsMemoryBytes(bsource source) {
        this.source = source;
    }

    @Override
    public byte[] asBytes() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        source.transferTo(baos);
        return baos.toByteArray();
    }
}
