package org.jimkast.ooj.bisource;

import org.jimkast.ooj.map.Mapping;
import org.jimkast.ooj.source.PSource;

public final class PsWithCounter<T> extends BiPSource.Env<T, Integer> {
    public PsWithCounter(PSource<T> origin) {
        this(1, origin);
    }

    public PsWithCounter(int i, PSource<T> origin) {
        super(new PsBiCombined<>(origin, new Indices<>(i)));
    }

    public static final class Indices<T> implements Mapping<T, Integer> {
        private int i;

        public Indices() {
            this(1);
        }

        public Indices(int i) {
            this.i = i;
        }

        public Integer map(T key) {
            return i++;
        }
    }
}
