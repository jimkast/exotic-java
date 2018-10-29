package org.jimkast.ooj.net;

import java.io.IOException;
import java.nio.ByteBuffer;
import sun.misc.Unsafe;

public final class SessionExchange implements Session {
    private final IOExchange exchange;

    public SessionExchange(IOExchange exchange) {
        this.exchange = exchange;
    }

    @Override
    public void accept(Conn channel) throws IOException {
        long l = Unsafe.getUnsafe().allocateMemory(16);
        ByteBuffer.allocateDirect(500);
        exchange.exchange(channel).feed(channel);
    }
}
