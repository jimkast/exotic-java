package org.jimkast.ooj.lang;

import org.jimkast.exotic.numberjdk.Int;
import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.source.Scalar;

public interface Quantity {
    int length();


    class Env implements Quantity {
        private final Quantity origin;

        public Env(Quantity origin) {
            this.origin = origin;
        }

        @Override
        public final int length() {
            return origin.length();
        }
    }


    final class Fixed implements Quantity {
        private final int length;

        public Fixed(int length) {
            this.length = length;
        }

        @Override
        public int length() {
            return length;
        }
    }


    final class OfScalar implements Quantity {
        private final Scalar<? extends Number> scalar;

        public OfScalar(Scalar<? extends Number> scalar) {
            this.scalar = scalar;
        }

        @Override
        public int length() {
            return scalar.value().intValue();
        }
    }


    final class AsInt extends Int {
        private final Quantity q;

        public AsInt(Quantity q) {
            this.q = q;
        }

        @Override
        public int intValue() {
            return q.length();
        }
    }


    final class Sum implements Quantity {
        private final Iterable<? extends Quantity> all;

        public Sum(Iterable<? extends Quantity> all) {
            this.all = all;
        }

        @Override
        public int length() {
            int sum = 0;
            for (Quantity q : all) {
                sum += q.length();
            }
            return sum;
        }
    }

    final class NotEmpty implements Cond {
        private final Quantity q;

        public NotEmpty(Quantity q) {
            this.q = q;
        }

        @Override
        public <X> X choose(X main, X other) {
            return q.length() > 0 ? main : other;
        }
    }

    final class Empty implements Cond {
        private final Quantity q;

        public Empty(Quantity q) {
            this.q = q;
        }

        @Override
        public <X> X choose(X main, X other) {
            return q.length() == 0 ? main : other;
        }
    }
}
