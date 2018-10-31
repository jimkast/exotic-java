package org.jimkast.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.jimkast.ooj.net.ByteSource;
import org.jimkast.ooj.net.OutStreamCloseable;

public final class RsBody implements RsServlet {
    private final ByteSource bs;

    public RsBody(ByteSource bs) {
        this.bs = bs;
    }

    @Override
    public void accept(HttpServletResponse res) throws IOException {
        bs.feed(new OutStreamCloseable.Of(res.getOutputStream()));
    }
}
