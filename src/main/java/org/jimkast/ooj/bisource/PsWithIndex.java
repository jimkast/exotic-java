package org.jimkast.ooj.bisource;

import org.jimkast.ooj.lang.BiPSource;
import org.jimkast.ooj.lang.Mapping;
import org.jimkast.ooj.lang.PSource;

public final class PsWithIndex<T> extends BiPSource.Env<T, Integer> {
    public PsWithIndex(PSource<T> origin) {
        this(0, origin);
    }

    public PsWithIndex(int i, PSource<T> origin) {
        super(new PsBiCombined<>(origin, new Indices<>(i)));
    }

    public static final class Indices<T> implements Mapping<T, Integer> {
        private int i;

        public Indices() {
            this(0);
        }

        public Indices(int i) {
            this.i = i;
        }

        public Integer map(T key) {
            return i++;
        }
    }
}
