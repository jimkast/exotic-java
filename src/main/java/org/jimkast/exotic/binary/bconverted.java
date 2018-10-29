package org.jimkast.exotic.binary;

import org.jimkast.exotic.util.scalar;
import org.jimkast.exotic.util.sticky;

public final class bconverted implements binary {
    private final scalar<binary> scalar;

    public bconverted(bconv conv, binary origin) {
        this(new sticky<>(new converted(conv, origin)));
    }

    public bconverted(scalar<binary> scalar) {
        this.scalar = scalar;
    }


    @Override
    public int map(int i) {
        return scalar.value().map(i);
    }

    @Override
    public int length() {
        return scalar.value().length();
    }


    public static final class converted implements scalar<binary> {
        private final bconv conv;
        private final binary origin;

        public converted(bconv conv, binary origin) {
            this.conv = conv;
            this.origin = origin;
        }

        @Override
        public binary value() {
            return conv.convert(origin);
        }
    }
}
