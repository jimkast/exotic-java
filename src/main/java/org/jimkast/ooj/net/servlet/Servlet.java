package org.jimkast.ooj.net.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Servlet {
    void accept(HttpServletRequest req, HttpServletResponse res) throws IOException;
}
