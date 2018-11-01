package org.jimkast.eshop.classpath;

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.HashMap;
import java.util.Map;

public final class UrlHandlerFactory implements URLStreamHandlerFactory {
    private final Map<String, URLStreamHandler> protocolHandlers;

    public UrlHandlerFactory() {
        this(new HashMap<>());
    }

    public UrlHandlerFactory(Map<String, URLStreamHandler> protocolHandlers) {
        this.protocolHandlers = protocolHandlers;
    }

    public UrlHandlerFactory with(String protocol, URLStreamHandler urlHandler) {
        protocolHandlers.put(protocol, urlHandler);
        return this;
    }

    public URLStreamHandler createURLStreamHandler(String protocol) {
        return protocolHandlers.get(protocol);
    }
}
