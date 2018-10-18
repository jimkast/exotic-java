package org.jimkast.exotic.net.http;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.exotic.io.bs.bsource;
import org.jimkast.exotic.possible.possible;
import org.jimkast.exotic.xml.v3.Markuped;

public interface HttpOut extends Markuped, bsource {

    class Envelope implements HttpOut {
        private final HttpOut origin;

        public Envelope(HttpOut origin) {
            this.origin = origin;
        }

        @Override
        public possible<Markuped> query(CharSequence q) {
            return origin.query(q);
        }

        @Override
        public CharSequence text() {
            return origin.text();
        }

        @Override
        public void transferTo(OutputStream out) throws IOException {
            origin.transferTo(out);
        }
    }
}
