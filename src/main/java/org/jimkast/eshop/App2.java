package org.jimkast.eshop;

import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.map.Case;
import org.jimkast.ooj.map.Choose;
import org.jimkast.ooj.net.BsString;
import org.jimkast.ooj.net.servlet.JettyServer;
import org.jimkast.ooj.net.servlet.JettyServletExchange;
import org.jimkast.ooj.net.servlet.Servlet;
import org.jimkast.servlet.RsBody;
import org.jimkast.servlet.ServletFixed;

public final class App2 {
    public static void main(String... args) throws Exception {
        new JettyServer(
            8080,
            new JettyServletExchange(
                new Servlet.Fork(
                    new Choose<>(
                        (req, res) -> res.getWriter().println("404!!!!"),
                        new Case<>(
                            req -> req.getRequestURI().startsWith("/a") ? Cond.TRUE : Cond.FALSE,
                            new ServletFixed(new RsBody(new BsString("sdfgfdg 34t gdfgf")))
                        ),
                        new Case<>(
                            req -> req.getRequestURI().startsWith("/b") ? Cond.TRUE : Cond.FALSE,
                            (req, res) -> res.getWriter().print("1111111")
                        )
                    )
                )
            )
        ).start();
    }
}
