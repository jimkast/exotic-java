package org.jimkast.ooj.cond;

public interface TriCheck<T> {
    Trilean test(T val);


    final class Compare implements TriCheck<Number> {
        private final Number other;

        public Compare(Number other) {
            this.other = other;
        }

        @Override
        public Trilean test(Number val) {
            return new NumberTrilean(val.intValue(), other.intValue());
        }
    }

    final class NumberTrilean implements Trilean {
        private final int a;
        private final int b;

        public NumberTrilean(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public <T> T choose(T opt1, T opt2, T opt3) {
            return a < b ? opt1 : a == b ? opt2 : opt3;
        }
    }
}
