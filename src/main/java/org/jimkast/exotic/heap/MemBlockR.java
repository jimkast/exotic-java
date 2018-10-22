package org.jimkast.exotic.heap;

import java.io.IOException;
import org.jimkast.exotic.net.OutStream;

public interface MemBlockR extends Countable, IntMapping, MemInput {

    class Env implements MemBlockR {
        private final MemBlockR origin;

        public Env(MemBlockR origin) {
            this.origin = origin;
        }

        @Override
        public final int length() {
            return origin.length();
        }

        @Override
        public final int map(int i) {
            return origin.map(i);
        }

        @Override
        public final void printTo(OutStream out, int offset, int length) throws IOException {
            origin.printTo(out, offset, length);
        }
    }


    final class DecCountable implements MemBlockR {
        private final Countable dec;
        private final MemBlockR origin;

        public DecCountable(Countable dec, MemBlockR origin) {
            this.dec = dec;
            this.origin = origin;
        }

        @Override
        public int length() {
            return dec.length();
        }

        @Override
        public int map(int i) {
            return origin.map(i);
        }

        @Override
        public void printTo(OutStream out, int offset, int length) throws IOException {
            origin.printTo(out, offset, length);
        }
    }


    final class DecIntMapping implements MemBlockR {
        private final IntMapping dec;
        private final MemBlockR origin;

        public DecIntMapping(IntMapping dec, MemBlockR origin) {
            this.dec = dec;
            this.origin = origin;
        }

        @Override
        public int length() {
            return origin.length();
        }

        @Override
        public int map(int i) {
            return dec.map(i);
        }

        @Override
        public void printTo(OutStream out, int offset, int length) throws IOException {
            origin.printTo(out, offset, length);
        }
    }


    final class DecMemInput implements MemBlockR {
        private final MemInput dec;
        private final MemBlockR origin;

        public DecMemInput(MemInput dec, MemBlockR origin) {
            this.dec = dec;
            this.origin = origin;
        }

        @Override
        public int length() {
            return origin.length();
        }

        @Override
        public int map(int i) {
            return origin.map(i);
        }

        @Override
        public void printTo(OutStream out, int offset, int length) throws IOException {
            dec.printTo(out, offset, length);
        }
    }

}
