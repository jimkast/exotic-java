package org.jimkast.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

public interface RsServlet {
    void accept(HttpServletResponse res) throws IOException;
}
