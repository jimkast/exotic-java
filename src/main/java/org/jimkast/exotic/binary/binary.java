package org.jimkast.exotic.binary;

import java.util.function.BiPredicate;
import org.jimkast.exotic.number.sub;
import org.jimkast.exotic.possible.index.with_index;
import org.jimkast.exotic.possible.mapped;
import org.jimkast.exotic.possible.possible;
import org.jimkast.exotic.possible.possible2;
import org.jimkast.exotic.possible.range;

public interface binary {
    int at(int i);

    int length();

    binary EMPTY = new binary() {
        @Override
        public int at(int i) {
            return 0;
        }

        @Override
        public int length() {
            return 0;
        }
    };

    BiPredicate<binary, binary> EQ = (b1, b2) -> {
        int len = b1.length();
        for (int i = 0; i < len; i++) {
            if (b1.at(i) != b2.at(i)) {
                return false;
            }
        }
        return true;
    };

    class env implements binary {
        private final binary origin;

        public env(binary origin) {
            this.origin = origin;
        }

        @Override
        public final int at(int i) {
            return origin.at(i);
        }

        @Override
        public final int length() {
            return origin.length();
        }
    }


    final class indices extends possible.env<Integer> {
        public indices(binary b) {
            super(new range(0, new sub(new blength(b), 1)));
        }
    }

    final class values extends possible.env<Integer> {
        public values(binary b) {
            super(new mapped<>(b::at, new indices(b)));
        }
    }

    final class pairs extends possible2.env<Integer, Integer> {
        public pairs(binary b) {
            super(new with_index<>(new values(b)));
        }
    }

    final class atindex implements byte32 {
        private final binary b;
        private final byte32 index;

        public atindex(binary b, byte32 index) {
            this.b = b;
            this.index = index;
        }

        @Override
        public int intValue() {
            return b.at(index.intValue());
        }
    }
}
