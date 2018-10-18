package org.jimkast.exotic.net;

import java.io.IOException;
import java.nio.channels.ServerSocketChannel;

public final class BackTcpNio implements BackCloseable {
    private final ServerSocketChannel s;

    public BackTcpNio(ServerSocketChannel s) {
        this.s = s;
    }

    @Override
    public void feed(Session session) throws IOException {
        session.accept(new ConnTcpNio(s.accept()));
    }

    @Override
    public void close() throws IOException {
        s.close();
    }
}
