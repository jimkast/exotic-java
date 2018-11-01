package org.jimkast.eshop.cms;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jimkast.ooj.net.servlet.Servlet;

public final class TkXsl implements Servlet {
    private final Xsl xsl;
    private final TkXml tk;

    public TkXsl(Xsl xsl, TkXml tk) {
        this.xsl = xsl;
        this.tk = tk;
    }

    @Override
    public void accept(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        xsl.accept(tk.map(req), res.getOutputStream());
    }
}
