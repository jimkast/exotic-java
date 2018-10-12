package org.jimkast.exotic.xml.v3;

import java.util.Iterator;

public interface Table {
    Row get(int i);

    int length();


    final class AsIterable implements Iterable<Row> {
        private final int start;
        private final Table tbl;

        public AsIterable(Table tbl) {
            this(0, tbl);
        }

        public AsIterable(int start, Table tbl) {
            this.start = start;
            this.tbl = tbl;
        }

        @Override
        public Iterator<Row> iterator() {
            return new AsIterator(tbl);
        }
    }


    final class AsIterator implements Iterator<Row> {
        private int i;
        private final Table tbl;

        public AsIterator(Table tbl) {
            this(0, tbl);
        }

        public AsIterator(int i, Table tbl) {
            this.i = i;
            this.tbl = tbl;
        }

        @Override
        public boolean hasNext() {
            return i < tbl.length();
        }

        @Override
        public Row next() {
            return tbl.get(i++);
        }
    }
}
