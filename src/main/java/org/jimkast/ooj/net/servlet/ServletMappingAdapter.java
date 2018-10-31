package org.jimkast.ooj.net.servlet;

import java.util.function.Consumer;
import java.util.function.Function;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jimkast.ooj.net.http.HttpOut;
import org.jimkast.ooj.net.http.HttpServerMapping;

public final class ServletMappingAdapter implements Servlet {
    private final Function<HttpOut, Consumer<HttpServletResponse>> rs;
    private final HttpServerMapping mapping;

    public ServletMappingAdapter(HttpServerMapping mapping) {
        this(RsServlet::new, mapping);
    }

    public ServletMappingAdapter(Function<HttpOut, Consumer<HttpServletResponse>> rs, HttpServerMapping mapping) {
        this.rs = rs;
        this.mapping = mapping;
    }

    @Override
    public void accept(HttpServletRequest req, HttpServletResponse res) {
        rs.apply(mapping.exchange(new ServletIn(req))).accept(res);
    }
}
