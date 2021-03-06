package org.jimkast.ooj.net.http;

import java.io.IOException;
import java.io.InputStream;
import org.cactoos.Input;
import org.jimkast.ooj.xml.Markuped;

public interface HttpIn extends Input {
    Markuped head();


    @Override
    InputStream stream() throws IOException;


    class Envelope implements HttpIn {
        private final HttpIn origin;

        public Envelope(HttpIn origin) {
            this.origin = origin;
        }

        @Override
        public Markuped head() {
            return origin.head();
        }

        @Override
        public InputStream stream() throws IOException {
            return origin.stream();
        }
    }
}
