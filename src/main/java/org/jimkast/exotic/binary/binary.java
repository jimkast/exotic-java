package org.jimkast.exotic.binary;

import org.jimkast.exotic.number.sub;
import org.jimkast.exotic.possible.mapped;
import org.jimkast.exotic.possible.possible;
import org.jimkast.exotic.possible.range;

public interface binary {
    int at(int i);

    int length();


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
