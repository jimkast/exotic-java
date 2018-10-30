package org.jimkast.ooj.heap;

import java.io.IOException;
import org.jimkast.ooj.lang.IntArray;
import org.jimkast.ooj.net.OutStream;
import org.jimkast.ooj.lang.IntIntMapping;
import org.jimkast.ooj.lang.Quantity;

public interface MemBlockR extends IntArray, MemInput {

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
        private final Quantity dec;
        private final MemBlockR origin;

        public DecCountable(Quantity dec, MemBlockR origin) {
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
        private final IntIntMapping dec;
        private final MemBlockR origin;

        public DecIntMapping(IntIntMapping dec, MemBlockR origin) {
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
