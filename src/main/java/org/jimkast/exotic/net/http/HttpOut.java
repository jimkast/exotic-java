package org.jimkast.exotic.net.http;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.exotic.io.bs.BytesSource;

public interface HttpOut extends HttpHead, BytesSource {
    @Override
    HttpLine line();

    @Override
    Iterable<Prop> headers();

    @Override
    void print(OutputStream out) throws IOException;


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
        public final void print(OutputStream out) throws IOException {
            origin.print(out);
        }
    }
}
