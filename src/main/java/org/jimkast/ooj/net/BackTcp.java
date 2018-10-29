package org.jimkast.ooj.net;

import java.io.IOException;
import java.net.ServerSocket;

public final class BackTcp implements BackCloseable {
    private final ConnFactory s;

    public BackTcp(ServerSocket s) {
        this(new TcpServerSocket(s));
    }

    public BackTcp(ConnFactory s) {
        this.s = s;
    }

    @Override
    public void feed(Session session) throws IOException {
        try (Conn conn = s.establish()) {
            session.accept(conn);
        }
    }

    @Override
    public void close() throws IOException {
        s.close();
    }
}
