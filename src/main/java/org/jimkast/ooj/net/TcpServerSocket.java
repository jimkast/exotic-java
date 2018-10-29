package org.jimkast.ooj.net;

import java.io.IOException;
import java.net.ServerSocket;

public final class TcpServerSocket implements ConnFactory {
    private final ServerSocket s;

    public TcpServerSocket(ServerSocket s) {
        this.s = s;
    }

    @Override
    public Conn establish() throws IOException {
        return new ConnTcp(s.accept());
    }

    @Override
    public void close() throws IOException {
        s.close();
    }
}
