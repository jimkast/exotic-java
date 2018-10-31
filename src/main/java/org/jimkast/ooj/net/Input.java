package org.jimkast.ooj.net;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;

public interface Input {
    InStreamCloseable stream() throws IOException;

    class Env implements Input {
        private final Input origin;

        public Env(Input origin) {
            this.origin = origin;
        }

        @Override
        public final InStreamCloseable stream() throws IOException {
            return origin.stream();
        }
    }

    final class Of extends Env {
        public Of(InStream in) {
            super(() -> new InStreamCloseable.AsCloseable(in));
        }

        public Of(InStreamCloseable in) {
            super(() -> in);
        }

        public Of(File file) {
            super(() -> {
                try {
                    return new InStreamCloseable.OfInputStream(new FileInputStream(file));
                } catch (FileNotFoundException e) {
                    throw new UncheckedIOException(e);
                }
            });
        }

        public Of(URL url) {
            super(() -> new InStreamCloseable.OfInputStream(url.openStream()));
        }
    }
}
