package org.jimkast.ooj.net;

import java.util.function.Function;
import org.jimkast.ooj.net.http.HttpIn;
import org.jimkast.ooj.net.http.HttpOut;
import org.jimkast.ooj.net.http.HttpServerMapping;

public final class HttpExchange implements IOExchange {
    private final Function<InStream, HttpIn> in_parser;
    private final Function<HttpOut, ByteSource> out_parser;
    private final HttpServerMapping mapping;

    public HttpExchange(Function<InStream, HttpIn> in_parser, Function<HttpOut, ByteSource> out_parser, HttpServerMapping mapping) {
        this.in_parser = in_parser;
        this.out_parser = out_parser;
        this.mapping = mapping;
    }

    @Override
    public ByteSource exchange(InStream in) {
        return out_parser.apply(mapping.exchange(in_parser.apply(in)));
    }
}
