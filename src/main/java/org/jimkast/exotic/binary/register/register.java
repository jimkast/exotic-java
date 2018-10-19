package org.jimkast.exotic.binary.register;

public interface register {
    void set(Number value);

    int value();


    final class smart implements register {
        private final register origin;

        public smart(register origin) {
            this.origin = origin;
        }

        public void inc() {
            origin.set(origin.value() + 1);
        }

        @Override
        public void set(Number value) {
            origin.set(value);
        }

        @Override
        public int value() {
            return origin.value();
        }
    }
}
