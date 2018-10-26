package org.jimkast.ooj.source.ints;

import org.jimkast.ooj.cond.ChkLt;
import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.map.Case;
import org.jimkast.ooj.map.Choose;
import org.jimkast.ooj.map.Mapping;

public final class Utf8Decoder implements IntSource {
    private static final int MASK = 0b00111111;
    private final IntSource origin;
    private final Mapping<Number, IntSource2> mapping;

    public Utf8Decoder(IntSource origin) {
        this(origin, new Choose<>(
            new Byte4(origin),
            new Case<>(
                new ChkLt(0b10000000),
                new Byte1()
            ),
            new Case<>(
                new ChkLt(0b11100000),
                new Byte2(origin)
            ),
            new Case<>(
                new ChkLt(0b11100000),
                new Byte3(origin)
            )
        ));
    }

    public Utf8Decoder(IntSource origin, Mapping<Number, IntSource2> mapping) {
        this.origin = origin;
        this.mapping = mapping;
    }

    @Override
    public Cond feed(IntTarget target) {
        return origin.feed(b -> mapping.map(b).feed(b, target));
    }


    public static final class Byte1 implements IntSource2 {
        @Override
        public Cond feed(int b, IntTarget target) {
            target.accept(b);
            return Cond.TRUE;
        }
    }

    public static final class Byte2 implements IntSource2 {
        private final IntSource s;

        public Byte2(IntSource s) {
            this.s = s;
        }

        @Override
        public Cond feed(int b, IntTarget target) {
            return s.feed(b2 -> target.accept(b & 0b00011111 << 6 | (b2 & MASK)));
        }
    }

    public static final class Byte3 implements IntSource2 {
        private final IntSource s;

        public Byte3(IntSource s) {
            this.s = s;
        }

        @Override
        public Cond feed(int b, IntTarget target) {
            return s.feed(b2 -> s.feed(b3 -> target.accept(b + b2 + b3)));
        }
    }

    public static final class Byte4 implements IntSource2 {
        private final IntSource s;

        public Byte4(IntSource s) {
            this.s = s;
        }

        @Override
        public Cond feed(int b, IntTarget target) {
            return s.feed(b2 -> s.feed(b3 -> s.feed(b4 -> target.accept(b + b2 + b3 + b4))));
        }
    }
}
