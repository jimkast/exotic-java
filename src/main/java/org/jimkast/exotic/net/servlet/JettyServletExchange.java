package org.jimkast.exotic.net.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.jimkast.exotic.net.http.HttpServerMapping;

public final class JettyServletExchange extends AbstractHandler {
    private final ServletExchange exchange;

    public JettyServletExchange(HttpServerMapping exchange) {
        this(new ServletMappingAdapter(exchange));
    }

    public JettyServletExchange(ServletExchange exchange) {
        this.exchange = exchange;
    }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        exchange.exchange(request, response);
        baseRequest.setHandled(true);
    }
}
