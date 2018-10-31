package org.jimkast.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jimkast.ooj.net.servlet.Servlet;
import org.jimkast.ooj.source.Target;

public final class Fixed implements Servlet {
    private final Target<HttpServletResponse> res;

    public Fixed(Target<HttpServletResponse> res) {
        this.res = res;
    }

    @Override
    public void accept(HttpServletRequest req, HttpServletResponse res) throws IOException {
        this.res.accept(res);
    }
}
