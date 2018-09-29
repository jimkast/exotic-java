package org.jimkast.exotic.io.bs;

import java.io.IOException;
import java.io.OutputStream;
import org.cactoos.Bytes;
import org.jimkast.exotic.io.BytesIoChecked;

public final class BsBytes implements bsource {
    private final Bytes bytes;

    public BsBytes(Bytes bytes) {
        this.bytes = bytes;
    }

    @Override
    public void transferTo(OutputStream out) throws IOException {
        out.write(new BytesIoChecked(bytes).asBytes());
    }
}
