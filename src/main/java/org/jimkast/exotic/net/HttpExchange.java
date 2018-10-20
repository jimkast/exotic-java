package org.jimkast.exotic.net;

import java.util.function.Function;
import org.jimkast.exotic.heap.InStream;
import org.jimkast.exotic.io.bs.bsource;
import org.jimkast.exotic.net.http.HttpIn;
import org.jimkast.exotic.net.http.HttpOut;
import org.jimkast.exotic.net.http.HttpServerMapping;

public final class HttpExchange implements IOExchange {
    private final Function<InStream, HttpIn> in_parser;
    private final Function<HttpOut, bsource> out_parser;
    private final HttpServerMapping mapping;

    public HttpExchange(Function<InStream, HttpIn> in_parser, Function<HttpOut, bsource> out_parser, HttpServerMapping mapping) {
        this.in_parser = in_parser;
        this.out_parser = out_parser;
        this.mapping = mapping;
    }

    @Override
    public bsource exchange(InStream in) {
        return out_parser.apply(mapping.exchange(in_parser.apply(in)));
    }
}
