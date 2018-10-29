package org.jimkast.ooj.xml;

import java.util.Collections;
import java.util.Iterator;
import org.cactoos.Func;
import org.cactoos.iterable.Filtered;
import org.jimkast.exotic.binary.binary;

public interface Xpath {
    Iterable<Row> apply(Row ctx, Table tbl);


    interface Filter extends Func<Row, Boolean> {
        @Override
        Boolean apply(Row row) throws Exception;
    }

    class Envelope implements Xpath {
        private final Xpath origin;

        public Envelope(Xpath origin) {
            this.origin = origin;
        }

        @Override
        public final Iterable<Row> apply(Row ctx, Table tbl) {
            return origin.apply(ctx, tbl);
        }
    }


    final class AxisChildren implements Xpath {
        @Override
        public Iterable<Row> apply(Row ctx, Table tbl) {
            int id = Row.INDEX.consume(ctx);
            return new Filtered<>(
                new FltChildren(id),
                new Table.AsIterable(tbl)
            );
        }
    }

    final class AxisParent implements Xpath {
        @Override
        public Iterable<Row> apply(Row ctx, Table tbl) {
            Row row = tbl.get(Row.PARENT.consume(ctx));
            return row.length() == 0 ? Collections.emptyList() : Collections.singletonList(row);
        }
    }

    final class AxisAncestor implements Xpath {
        @Override
        public Iterable<Row> apply(Row ctx, Table tbl) {
            return () -> new AxisUpIterator(tbl, ctx);
        }
    }


    final class AxisPreceding implements Xpath {
        @Override
        public Iterable<Row> apply(Row ctx, Table tbl) {
            int id = Row.INDEX.consume(ctx);
            int parent = Row.PARENT.consume(ctx);
            return new Filtered<>(
                row -> Row.PARENT.consume(ctx) == parent && Row.INDEX.consume(ctx) < id,
                new Table.AsIterable(tbl)
            );
        }
    }


    final class AxisFollowing implements Xpath {
        @Override
        public Iterable<Row> apply(Row ctx, Table tbl) {
            int id = Row.INDEX.consume(ctx);
            int parent = Row.PARENT.consume(ctx);
            return new Filtered<>(
                row -> Row.PARENT.consume(ctx) == parent && Row.INDEX.consume(ctx) > id,
                new Table.AsIterable(tbl)
            );
        }
    }


    final class AxisDescendant implements Xpath {
        @Override
        public Iterable<Row> apply(Row ctx, Table tbl) {
            int depth = Row.DEPTH.consume(ctx);
            int id = Row.INDEX.consume(ctx);
            int id_max = Row.INDEX.consume(ctx);
            return new Filtered<>(
                row -> Row.INDEX.consume(row) > id && Row.INDEX.consume(row) < id_max,
                new Table.AsIterable(tbl)
            );
        }
    }

    final class AxisSelf implements Xpath {
        @Override
        public Iterable<Row> apply(Row ctx, Table tbl) {
            return Collections.singletonList(ctx);
        }
    }


    final class AxisUpIterator implements Iterator<Row> {
        private final Table tbl;
        private Row row;

        public AxisUpIterator(Table tbl, Row row) {
            this.tbl = tbl;
            this.row = row;
        }

        @Override
        public boolean hasNext() {
            return row.length() == 0;
        }

        @Override
        public Row next() {
            return row = tbl.get(Row.PARENT.consume(row));
        }
    }

    final class FltChildren implements Filter {
        private final int parent;

        public FltChildren(int parent) {
            this.parent = parent;
        }

        @Override
        public Boolean apply(Row row) throws Exception {
            return Row.PARENT.consume(row) == parent;
        }
    }

    final class FltByName implements Filter {
        private final binary name;

        public FltByName(binary name) {
            this.name = name;
        }

        @Override
        public Boolean apply(Row row) throws Exception {
            return binary.EQ.test(name, Row.NAME.consume(row));
        }
    }
}
