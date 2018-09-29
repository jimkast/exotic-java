package org.jimkast.exotic.io.bs;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public interface bsource {
    void transferTo(OutputStream out) throws IOException;

    bsource EMPTY = new empty();


    final class empty implements bsource {
        @Override
        public void transferTo(OutputStream out) throws IOException {

        }
    }


    class env implements bsource {
        private final bsource origin;

        public env(bsource origin) {
            this.origin = origin;
        }

        @Override
        public final void transferTo(OutputStream out) throws IOException {
            origin.transferTo(out);
        }
    }

    final class all implements bsource {
        private final Iterable<bsource> all;

        public all(bsource... all) {
            this(Arrays.asList(all));
        }

        public all(Iterable<bsource> all) {
            this.all = all;
        }

        @Override
        public void transferTo(OutputStream out) throws IOException {
            for (bsource source : all) {
                source.transferTo(out);
            }
        }
    }
}
