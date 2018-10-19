package org.jimkast.exotic.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public final class ConnUdp implements Conn {
    private final DatagramSocket s;

    public ConnUdp(DatagramSocket s) {
        this.s = s;
    }

    @Override
    public int read(byte[] block, int offset, int len) throws IOException {
        DatagramPacket p = new DatagramPacket(block, offset, len);
        s.receive(p);
        return p.getLength();
    }

    @Override
    public void write(byte[] block, int offset, int len) throws IOException {
        s.send(new DatagramPacket(block, offset, len));
    }

    @Override
    public void close() {
        s.close();
    }
}
