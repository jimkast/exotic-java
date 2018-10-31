package org.jimkast.ooj.net;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public final class BsString implements ByteSource {
    private final String s;
    private final Charset cs;

    public BsString(String s) {
        this(s, StandardCharsets.UTF_8);
    }

    public BsString(String s, Charset cs) {
        this.s = s;
        this.cs = cs;
    }

    @Override
    public void feed(OutStream out) throws IOException {
        byte[] b = s.getBytes(cs);
        out.accept(b, 0, b.length);
    }
}
