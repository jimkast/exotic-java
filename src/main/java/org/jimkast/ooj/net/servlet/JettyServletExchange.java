package org.jimkast.ooj.net.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.jimkast.ooj.net.http.HttpServerMapping;

public final class JettyServletExchange extends AbstractHandler {
    private final Servlet exchange;

    public JettyServletExchange(HttpServerMapping exchange) {
        this(new ServletMappingAdapter(exchange));
    }

    public JettyServletExchange(Servlet exchange) {
        this.exchange = exchange;
    }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        exchange.accept(request, response);
        baseRequest.setHandled(true);
    }
}
