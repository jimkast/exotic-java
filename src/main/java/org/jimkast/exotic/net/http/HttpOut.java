package org.jimkast.exotic.net.http;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.exotic.io.bs.bsource;

public interface HttpOut extends HttpHead, bsource {
    @Override
    HttpLine line();

    @Override
    Iterable<Prop> headers();

    @Override
    void transferTo(OutputStream out) throws IOException;


    class Envelope implements HttpOut {
        private final HttpOut origin;

        public Envelope(HttpOut origin) {
            this.origin = origin;
        }

        @Override
        public final HttpLine line() {
            return origin.line();
        }

        @Override
        public final Iterable<Prop> headers() {
            return origin.headers();
        }

        @Override
        public final void transferTo(OutputStream out) throws IOException {
            origin.transferTo(out);
        }
    }
}
