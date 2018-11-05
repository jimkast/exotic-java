package org.jimkast.eshop.cms;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jimkast.ooj.net.BsInput;
import org.jimkast.ooj.net.InStreamCloseable;
import org.jimkast.ooj.net.OutStreamCloseable;
import org.jimkast.ooj.net.servlet.Servlet;

public final class TkFile implements Servlet {
    private final CharSequence base;

    public TkFile(CharSequence base) {
        this.base = base;
    }

    @Override
    public void accept(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try (InputStream in = new URL(base + req.getRequestURI()).openStream()) {
            new BsInput(new InStreamCloseable.OfInputStream(in)).feed(new OutStreamCloseable.Of(res.getOutputStream()));
        }
    }
}
