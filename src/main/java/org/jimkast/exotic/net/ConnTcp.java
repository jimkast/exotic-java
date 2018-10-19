package org.jimkast.exotic.net;

import java.io.IOException;
import java.net.Socket;

public final class ConnTcp implements Conn {
    private final Socket s;

    public ConnTcp(Socket s) {
        this.s = s;
    }

    @Override
    public int read(byte[] block, int offset, int len) throws IOException {
        return s.getInputStream().read(block, offset, len);
    }

    @Override
    public void write(byte[] block, int offset, int len) throws IOException {
        s.getOutputStream().write(block, offset, len);
    }

    @Override
    public void close() throws IOException {
        s.close();
    }
}
