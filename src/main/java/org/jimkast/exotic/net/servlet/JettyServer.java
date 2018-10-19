package org.jimkast.exotic.net.servlet;

import java.io.Closeable;
import java.io.IOException;
import org.eclipse.jetty.server.Handler;
import org.jimkast.exotic.net.Server;

public final class JettyServer implements Server {
    private final Number port;
    private final Handler handler;

    public JettyServer(Number port, Handler handler) {
        this.port = port;
        this.handler = handler;
    }

    @Override
    public Closeable start() throws IOException {
        org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server(port.intValue());
        server.setHandler(handler);
        try {
            server.start();
            server.join();
            return () -> {
                try {
                    server.stop();
                } catch (Exception e) {
                    throw new IOException(e);
                }
            };
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
