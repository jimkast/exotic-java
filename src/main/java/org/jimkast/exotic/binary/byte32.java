package org.jimkast.exotic.binary;

public interface byte32 {
    int val();

    class env implements byte32 {
        private final byte32 origin;

        public env(byte32 origin) {
            this.origin = origin;
        }

        @Override
        public int val() {
            return origin.val();
        }
    }


    final class fixed implements byte32 {
        private final int val;

        public fixed(int val) {
            this.val = val;
        }

        @Override
        public int val() {
            return val;
        }
    }


    final class cached implements byte32 {
        private final byte32 origin;
        private int cache;
        private int loaded = 0;

        public cached(byte32 origin) {
            this.origin = origin;
        }

        @Override
        public int val() {
            if (loaded++ == 0) {
                cache = origin.val();
            }
            return cache;
        }
    }
}
