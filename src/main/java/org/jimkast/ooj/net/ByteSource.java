package org.jimkast.ooj.net;

import java.io.IOException;
import java.io.UncheckedIOException;
import org.jimkast.ooj.source.PsForEach;
import org.jimkast.ooj.source.PsMapped;
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
        public final void feed(OutStream out) throws IOException {
            origin.feed(out);
        }
    }


    final class Safe implements ByteSource {
        private final ByteSource origin;

        public Safe(ByteSource origin) {
            this.origin = origin;
        }

        @Override
        public void feed(OutStream out) {
            try {
                origin.feed(out);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }


    final class All implements ByteSource {
        private final Source<Safe> all;

        public All(ByteSource... all) {
            this(new PsOfArray<>(all));
        }

        public All(Source<ByteSource> all) {
            this(0, new PsForEach<>(all));
        }

        public All(int dummy, Source<ByteSource> all) {
            this.all = new PsMapped<>(Safe::new, all);
        }

        @Override
        public void feed(OutStream out) {
            all.feed(bs -> bs.feed(out));
        }
    }
}
