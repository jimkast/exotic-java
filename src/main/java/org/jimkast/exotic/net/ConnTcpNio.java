package org.jimkast.exotic.net;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public final class ConnTcpNio implements Conn {
    private final SocketChannel s;

    public ConnTcpNio(SocketChannel s) {
        this.s = s;
    }

    @Override
    public int read(byte[] block, int offset, int len) throws IOException {
        return s.read(ByteBuffer.wrap(block, offset, len));
    }

    @Override
    public void write(byte[] block, int offset, int len) throws IOException {
        s.write(ByteBuffer.wrap(block, offset, len));
    }

    @Override
    public void close() throws IOException {
        s.close();
    }
}
