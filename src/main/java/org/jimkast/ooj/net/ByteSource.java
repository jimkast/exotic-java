package org.jimkast.ooj.net;

import java.io.IOException;
import java.io.UncheckedIOException;
import org.jimkast.ooj.source.PsForEach;
import org.jimkast.ooj.source.PsOfArray;
import org.jimkast.ooj.source.Source;

public interface ByteSource {
    void feed(OutStream out) throws IOException;

    class Env implements ByteSource {
        private final ByteSource origin;

        public Env(ByteSource origin) {
            this.origin = origin;
        }

        @Override
        public void feed(OutStream out) throws IOException {
            origin.feed(out);
        }
    }

    final class All implements ByteSource {
        private final Source<ByteSource> all;

        public All(ByteSource... all) {
            this(new PsOfArray<>(all));
        }

        public All(Source<ByteSource> all) {
            this(0, new PsForEach<>(all));
        }

        public All(int dummy, Source<ByteSource> all) {
            this.all = all;
        }

        @Override
        public void feed(OutStream out) throws IOException {
            all.feed(bs -> {
                try {
                    bs.feed(out);
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            });
        }
    }
}
