package org.jimkast.ooj.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public final class ConnUdp implements Conn {
    private final DatagramSocket s;

    public ConnUdp(DatagramSocket s) {
        this.s = s;
    }

    @Override
    public int read(byte[] b, int offset, int length) throws IOException {
        DatagramPacket p = new DatagramPacket(b, offset, length);
        s.receive(p);
        return p.getLength();
    }

    @Override
    public void accept(byte[] b, int offset, int length) throws IOException {
        s.send(new DatagramPacket(b, offset, length));
    }

    @Override
    public void close() {
        s.close();
    }
}
