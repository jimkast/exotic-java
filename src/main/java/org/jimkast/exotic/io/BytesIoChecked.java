package org.jimkast.exotic.io;

import java.io.IOException;
import org.cactoos.Bytes;

public final class BytesIoChecked implements Bytes {
    private final Bytes origin;

    public BytesIoChecked(Bytes origin) {
        this.origin = origin;
    }

    @Override
    public byte[] asBytes() throws IOException {
        try {
            return origin.asBytes();
        } catch (RuntimeException | IOException e) {
            throw e;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
