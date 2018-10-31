package org.jimkast.ooj.net;

import java.io.IOException;
import java.net.Socket;

public final class ConnTcp implements Conn {
    private final Socket s;

    public ConnTcp(Socket s) {
        this.s = s;
    }

    @Override
    public int read(byte[] b, int offset, int length) throws IOException {
        return s.getInputStream().read(b, offset, length);
    }

    @Override
    public void accept(byte[] b, int offset, int length) throws IOException {
        s.getOutputStream().write(b, offset, length);
    }

    @Override
    public void close() throws IOException {
        s.close();
    }
}
