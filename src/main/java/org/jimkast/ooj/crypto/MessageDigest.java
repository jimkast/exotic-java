package org.jimkast.ooj.crypto;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import org.jimkast.ooj.heap.HeapBlock;
import org.jimkast.ooj.lang.Quantity;
import org.jimkast.ooj.net.InStream;
import org.jimkast.ooj.net.OutStream;

public interface MessageDigest extends OutStream, Quantity, InStream {

    final class Jdk implements MessageDigest {
        private final java.security.MessageDigest md;

        public Jdk(String algorithm) {
            try {
                this.md = java.security.MessageDigest.getInstance(algorithm);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

        public Jdk(java.security.MessageDigest md) {
            this.md = md;
        }

        @Override
        public int read(HeapBlock heap) throws IOException {
            try {
                return heap.readFrom(md::digest);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


        @Override
        public int length() {
            return md.getDigestLength();
        }

        @Override
        public void accept(HeapBlock heap) throws IOException {
            heap.feed(md::update);
        }
    }
}
