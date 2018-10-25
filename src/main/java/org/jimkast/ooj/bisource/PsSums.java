package org.jimkast.ooj.bisource;

import org.jimkast.ooj.map.Mapping;
import org.jimkast.ooj.source.PSource;

public final class PsSums extends PSource.Env<Number> {
    public PsSums(PSource<Number> origin) {
        super(new PsBi2<>(new PsBiCombined<>(origin, new Sum())));
    }

    public static final class Sum implements Mapping<Number, Number> {
        private int sum = 0;

        @Override
        public Number map(Number key) {
            return sum += key.doubleValue();
        }
    }
}
