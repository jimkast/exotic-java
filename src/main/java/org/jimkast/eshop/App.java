package org.jimkast.eshop;

import java.net.URL;
import org.jimkast.eshop.classpath.ClasspathUrlHandler;
import org.jimkast.eshop.classpath.UrlHandlerFactory;
import org.jimkast.eshop.cms.Saxon;
import org.jimkast.eshop.cms.TkFile;
import org.jimkast.eshop.cms.TkIndex;
import org.jimkast.eshop.cms.TkXsl;
import org.jimkast.eshop.cms.Xsl;
import org.jimkast.ooj.bool.And;
import org.jimkast.ooj.map.iterable.Case;
import org.jimkast.ooj.net.BsString;
import org.jimkast.ooj.net.servlet.JettyServer;
import org.jimkast.ooj.net.servlet.JettyServletExchange;
import org.jimkast.ooj.net.servlet.Servlet;
import org.jimkast.servlet.ChkForMethod;
import org.jimkast.servlet.ChkForPath;
import org.jimkast.servlet.ChkRegex;
import org.jimkast.servlet.RsBody;
import org.jimkast.servlet.ServletFixed;

public final class App {
    public static void main(String... args) throws Exception {
        URL.setURLStreamHandlerFactory(new UrlHandlerFactory()
            .with("classpath", new ClasspathUrlHandler())
        );

        Saxon saxon = new Saxon();
        Xsl xsl = saxon.compile("src/main/resources/templates/index.xsl");

        new JettyServer(
            8080,
            new JettyServletExchange(
                new Servlet.Fork(
                    (req, res) -> res.getWriter().println("404!!!!"),
                    new Case<>(
                        new And<>(
                            new ChkForMethod("GET"),
                            new ChkForPath("/xml")
                        ),
                        new TkXsl(xsl, new TkIndex())
                    ),
                    new Case<>(new ChkForPath(path ->
                        path.toString().startsWith("/xml")),
                        new TkFile("https://www.w3schools.com")
                    ),
                    new Case<>(
                        new And<>(
                            new ChkForMethod("GET"),
                            new ChkForPath("/test")
                        ),
                        new ServletFixed(new RsBody(new BsString("sdfgfdg 34t gdfgf")))
                    ),
                    new Case<>(
                        new And<>(
                            new ChkForMethod("GET"),
                            new ChkForPath("/a.+")
                        ),
                        (req, res) -> res.getWriter().print("1111111")
                    ),
                    new Case<>(
                        new ChkForPath(new ChkRegex("/b.+")),
                        (req, res) -> res.getWriter().print("2222222")
                    )
                )
            )
        ).start();
    }
}
