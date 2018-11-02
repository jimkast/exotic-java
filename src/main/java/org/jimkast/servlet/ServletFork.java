package org.jimkast.servlet;

import java.io.IOException;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jimkast.ooj.map.Mapping;
import org.jimkast.ooj.map.iterable.Choose;
import org.jimkast.ooj.net.servlet.Servlet;

public final class ServletFork implements Servlet {
    private final Mapping<HttpServletRequest, Servlet> mapping;

    @SafeVarargs
    public ServletFork(Servlet def, Mapping<HttpServletRequest, Iterator<Servlet>>... mappings) {
        this(new Choose<>(def, mappings));
    }

    public ServletFork(Mapping<HttpServletRequest, Servlet> mapping) {
        this.mapping = mapping;
    }

    @Override
    public void accept(HttpServletRequest req, HttpServletResponse res) throws IOException {
        mapping.map(req).accept(req, res);
    }
}
