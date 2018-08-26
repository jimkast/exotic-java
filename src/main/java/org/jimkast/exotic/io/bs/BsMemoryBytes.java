package org.jimkast.exotic.io.bs;

import java.io.ByteArrayOutputStream;
import org.cactoos.Bytes;

public final class BsMemoryBytes implements Bytes {
    private final BytesSource source;

    public BsMemoryBytes(BytesSource source) {
        this.source = source;
    }

    @Override
    public byte[] asBytes() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        source.print(baos);
        return baos.toByteArray();
    }
}
