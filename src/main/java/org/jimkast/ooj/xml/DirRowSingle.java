package org.jimkast.ooj.xml;

public interface DirRowSingle {
    int consume(Row row);

    class Envelope implements DirRowSingle {
        private final DirRowSingle origin;

        public Envelope(DirRowSingle origin) {
            this.origin = origin;
        }

        @Override
        public final int consume(Row row) {
            return origin.consume(row);
        }
    }

    final class ByNum implements DirRowSingle {
        private final int index;

        public ByNum(int index) {
            this.index = index;
        }

        @Override
        public int consume(Row row) {
            return row.single(index);
        }
    }
}
