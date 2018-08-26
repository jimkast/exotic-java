package org.jimkast.exotic.io.input;

import java.io.IOException;
import java.io.InputStream;
import org.cactoos.Input;

public final class InputIoChecked implements Input {
    private final Input origin;

    public InputIoChecked(Input origin) {
        this.origin = origin;
    }

    @Override
    public InputStream stream() throws IOException {
        try {
            return origin.stream();
        } catch (RuntimeException | IOException e) {
            throw e;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
