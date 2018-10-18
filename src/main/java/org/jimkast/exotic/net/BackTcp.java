package org.jimkast.exotic.net;

import java.io.IOException;
import java.net.ServerSocket;

public final class BackTcp implements BackCloseable {
    private final ServerSocket s;

    public BackTcp(ServerSocket s) {
        this.s = s;
    }

    @Override
    public void feed(Session session) throws IOException {
        session.accept(new ConnTcp(s.accept()));
    }

    @Override
    public void close() throws IOException {
        s.close();
    }
}
