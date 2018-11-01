package org.jimkast.eshop.classpath;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public final class ClasspathUrlHandler extends URLStreamHandler {

    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        return Thread.currentThread().getContextClassLoader().getResource(u.getPath().substring(1)).openConnection();
    }
}