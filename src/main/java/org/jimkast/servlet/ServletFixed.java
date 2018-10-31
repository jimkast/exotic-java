package org.jimkast.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jimkast.ooj.net.servlet.Servlet;

public final class ServletFixed implements Servlet {
    private final RsServlet res;

    public ServletFixed(RsServlet res) {
        this.res = res;
    }

    @Override
    public void accept(HttpServletRequest req, HttpServletResponse res) throws IOException {
        this.res.accept(res);
    }
}
