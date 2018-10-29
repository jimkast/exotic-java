package org.jimkast.ooj.net.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;
import javax.servlet.http.HttpServletRequest;
import org.jimkast.ooj.net.http.HttpIn;
import org.jimkast.ooj.xml.Markuped;

public final class ServletIn implements HttpIn, Markuped {
    private final HttpServletRequest req;

    public ServletIn(HttpServletRequest req) {
        this.req = req;
    }

    @Override
    public InputStream stream() throws IOException {
        return req.getInputStream();
    }

    @Override
    public Markuped head() {
        return this;
    }

    @Override
    public Markuped query(CharSequence q) {
        return null;
    }

    @Override
    public CharSequence text() {
        return null;
    }

    @Override
    public void supply(Consumer<? super Markuped> consumer) {

    }
}
