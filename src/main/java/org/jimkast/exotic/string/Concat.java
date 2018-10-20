package org.jimkast.exotic.string;

import java.io.IOException;
import java.util.List;
import org.jimkast.exotic.map.MappingInt;
import org.jimkast.exotic.net.OutStream;

public final class Concat implements MemBlockR {
    private final MappingInt<MemBlockR> mapping;
    private final Countable sum;

    public Concat(Iterable<MemBlockR> all) {
        this(new Mapping<>(all), new Sum(all));
    }

    Concat(MappingInt<MemBlockR> mapping, Countable all) {
        this.mapping = mapping;
        this.sum = all;
    }

    @Override
    public int map(int i) {
        return mapping.map(i).map(0);
    }

    @Override
    public int length() {
        return sum.length();
    }

    @Override
    public void printTo(OutStream out, int offset, int length) throws IOException {
        mapping.map(offset).printTo(out, 0, length);
    }


    public final static class Mapping<T extends Countable> implements MappingInt<T> {
        private final Iterable<T> all;

        public Mapping(Iterable<T> all) {
            this.all = all;
        }

        @Override
        public T map(int index) {
            int count = 0;
            for (T s : all) {
                count += s.length();
                if (count > index) {
                    return s;
                }
            }
            throw new IndexOutOfBoundsException("For index " + index);
        }
    }

    public final static class BinaryMapping<T extends Countable> implements MappingInt<T> {
        private final List<Integer> all;

        public BinaryMapping(List<Integer> all) {
            this.all = all;
        }

        @Override
        public T map(int index) {
            int from = 0;
            int to = all.size() - 1;
            int count = 0;

            for (int s : all) {

            }
            throw new IndexOutOfBoundsException("For index " + index);
        }
    }
}
