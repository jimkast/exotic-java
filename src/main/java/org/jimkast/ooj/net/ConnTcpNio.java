package org.jimkast.ooj.net;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public final class ConnTcpNio implements Conn {
    private final SocketChannel s;

    public ConnTcpNio(SocketChannel s) {
        this.s = s;
    }

    @Override
    public int read(byte[] b, int offset, int length) throws IOException {
        return s.read(ByteBuffer.wrap(b, offset, length));
    }

    @Override
    public void accept(byte[] b, int offset, int length) throws IOException {
        s.write(ByteBuffer.wrap(b, offset, length));
    }

    @Override
    public void close() throws IOException {
        s.close();
    }
}
