package org.jimkast.exotic.net.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ServletExchange {
    void exchange(HttpServletRequest req, HttpServletResponse res);
}
