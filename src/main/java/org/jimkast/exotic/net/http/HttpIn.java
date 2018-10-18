package org.jimkast.exotic.net.http;

import java.io.IOException;
import java.io.InputStream;
import org.cactoos.Input;
import org.jimkast.exotic.possible.possible;
import org.jimkast.exotic.xml.v3.Markuped;

public interface HttpIn extends Markuped, Input {

    @Override
    InputStream stream() throws IOException;


    class Envelope implements HttpIn {
        private final HttpIn origin;

        public Envelope(HttpIn origin) {
            this.origin = origin;
        }

        @Override
        public final InputStream stream() throws IOException {
            return origin.stream();
        }

        @Override
        public possible<Markuped> query(CharSequence q) {
            return origin.query(q);
        }

        @Override
        public CharSequence text() {
            return origin.text();
        }
    }
}
