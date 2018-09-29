package org.jimkast.exotic.binary;

public interface byte32 {
    int intValue();

    class env implements byte32 {
        private final byte32 origin;

        public env(byte32 origin) {
            this.origin = origin;
        }

        @Override
        public int intValue() {
            return origin.intValue();
        }
    }


    final class fixed implements byte32 {
        private final int val;

        public fixed(int val) {
            this.val = val;
        }

        @Override
        public int intValue() {
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
        public int intValue() {
            if (loaded++ == 0) {
                cache = origin.intValue();
            }
            return cache;
        }
    }
}
