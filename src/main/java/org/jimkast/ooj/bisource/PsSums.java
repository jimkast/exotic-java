package org.jimkast.ooj.bisource;

import org.jimkast.ooj.map.Mapping;
import org.jimkast.ooj.source.Source;

public final class PsSums extends Source.Env<Number> {
    public PsSums(Source<Number> origin) {
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
