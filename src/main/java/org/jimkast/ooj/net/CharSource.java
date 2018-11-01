package org.jimkast.ooj.net;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.io.Writer;
import org.jimkast.ooj.source.PsForEach;
import org.jimkast.ooj.source.PsMapped;
import org.jimkast.ooj.source.PsOfArray;
import org.jimkast.ooj.source.Source;

public interface CharSource {
    void feed(Writer out) throws IOException;

    class Env implements CharSource {
        private final CharSource origin;

        public Env(CharSource origin) {
            this.origin = origin;
        }

        @Override
        public final void feed(Writer out) throws IOException {
            origin.feed(out);
        }
    }


    final class Safe implements CharSource {
        private final CharSource origin;

        public Safe(CharSource origin) {
            this.origin = origin;
        }

        @Override
        public void feed(Writer out) {
            try {
                origin.feed(out);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }


    final class All implements CharSource {
        private final Source<Safe> all;

        public All(CharSource... all) {
            this(new PsOfArray<>(all));
        }

        public All(Source<CharSource> all) {
            this(0, new PsForEach<>(all));
        }

        public All(int dummy, Source<CharSource> all) {
            this.all = new PsMapped<>(Safe::new, all);
        }

        @Override
        public void feed(Writer out) {
            all.feed(bs -> bs.feed(out));
        }
    }
}
