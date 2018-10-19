package org.jimkast.exotic.net.http;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.exotic.io.bs.bsource;
import org.jimkast.exotic.xml.v3.Markuped;

public interface HttpOut extends bsource {
    Markuped head();

    class Envelope implements HttpOut {
        private final HttpOut origin;

        public Envelope(HttpOut origin) {
            this.origin = origin;
        }

        @Override
        public Markuped head() {
            return origin.head();
        }

        @Override
        public void transferTo(OutputStream out) throws IOException {
            origin.transferTo(out);
        }
    }
}
