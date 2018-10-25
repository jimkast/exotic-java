package org.jimkast.ooj.lang;

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
}
