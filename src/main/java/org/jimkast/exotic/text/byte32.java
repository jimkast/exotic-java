package org.jimkast.exotic.text;

public interface byte32 {
    int value();

    class env implements byte32 {
        private final byte32 origin;

        public env(byte32 origin) {
            this.origin = origin;
        }

        @Override
        public int value() {
            return origin.value();
        }
    }


    final class fixed implements byte32 {
        private final int val;

        public fixed(int val) {
            this.val = val;
        }

        @Override
        public int value() {
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
        public int value() {
            if (loaded++ == 0) {
                cache = origin.value();
            }
            return cache;
        }
    }
}
