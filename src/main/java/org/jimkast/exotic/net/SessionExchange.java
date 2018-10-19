package org.jimkast.exotic.net;

import java.io.IOException;

public final class SessionExchange implements Session {
    private final IOExchange exchange;

    public SessionExchange(IOExchange exchange) {
        this.exchange = exchange;
    }

    @Override
    public void accept(Conn channel) throws IOException {
        exchange.exchange(channel).transferTo(new OutStream.AsOutputStream(channel));
    }
}
