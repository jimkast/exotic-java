package org.jimkast.exotic.text;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.cactoos.Input;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.io.bs.bsource;

public final class bytes_part implements binary, bsource, Input {
    private final byte[] arr;
    private final int off;
    private final int len;

    public bytes_part(byte[] arr) {
        this(arr, 0);
    }

    public bytes_part(byte[] arr, int off) {
        this(arr, off, arr.length);
    }

    public bytes_part(byte[] arr, int off, int len) {
        this.arr = arr;
        this.off = off;
        this.len = len;
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
        out.write(arr, off, len);
    }

    @Override
    public InputStream stream() {
        return new ByteArrayInputStream(arr, off, len);
    }
}
