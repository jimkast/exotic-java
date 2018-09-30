package org.jimkast.exotic.text;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.cactoos.Input;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.io.bs.bsource;

public final class bytes implements binary, bsource, Input {
    private final byte[] arr;

    public bytes(byte[] arr) {
        this.arr = arr;
    }

    @Override
    public int at(int i) {
        return arr[i];
    }

    @Override
    public int length() {
        return arr.length;
    }

    @Override
    public void transferTo(OutputStream out) throws IOException {
        out.write(arr);
    }

    @Override
    public InputStream stream() {
        return new ByteArrayInputStream(arr);
    }
}
