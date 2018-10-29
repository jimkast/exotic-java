package org.jimkast.ooj.net.servlet;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.function.Consumer;
import javax.servlet.http.HttpServletResponse;
import org.jimkast.ooj.net.http.HttpOut;
import org.jimkast.exotic.possible.while_present;
import org.jimkast.exotic.xml.v3.Markuped;

public final class RsServlet implements Consumer<HttpServletResponse> {
    private final HttpOut res;

    public RsServlet(HttpOut res) {
        this.res = res;
    }

    @Override
    public void accept(HttpServletResponse out) {
        Markuped head = res.head();
        out.setStatus(Integer.parseInt(head.query("line/status").text().toString()));
        new while_present<>(head.query("header")).supply(
            markuped -> out.addHeader(head.query("name").text().toString(), head.query("value").text().toString())
        );
        try {
            res.transferTo(out.getOutputStream());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
