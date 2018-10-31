package org.jimkast.servlet;

import javax.servlet.http.HttpServletResponse;
import org.jimkast.ooj.source.Target;

public interface RsServlet extends Target<HttpServletResponse> {
    void accept(HttpServletResponse res);
}
