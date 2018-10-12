package org.jimkast.exotic.xml.v3;

import org.jimkast.exotic.binary.binary;

public interface DirRowBinary {
    binary consume(Row row);

    class Envelope implements DirRowBinary {
        private final DirRowBinary origin;

        public Envelope(DirRowBinary origin) {
            this.origin = origin;
        }

        @Override
        public final binary consume(Row row) {
            return origin.consume(row);
        }
    }

    final class ByNum implements DirRowBinary {
        private final int index;

        public ByNum(int index) {
            this.index = index;
        }

        @Override
        public binary consume(Row row) {
            return row.binary(index);
        }
    }
}
