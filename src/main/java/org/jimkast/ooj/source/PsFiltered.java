package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.map.Mapping;

public final class PsFiltered<T> extends PSource.Env<T> {
    public PsFiltered(Check<T> check, PSource<T> origin) {
        super(new PsStore<>(
            new PsMapping<>(
                new FilteredMapping<>(
                    new Check.Not<>(check),
                    origin
                )
            )
        ));
    }


    public static final class FilteredMapping<T> implements Mapping<Target<T>, PSource<T>> {
        private final Check<T> check;
        private final PSource<T> origin;

        public FilteredMapping(Check<T> check, PSource<T> origin) {
            this.check = check;
            this.origin = origin;
        }

        @Override
        public PSource<T> map(Target<T> store) {
            return new PsWithFixedTarget<>(Target.Noop.instance(),
                new PsForEach<>(
                    new PsWhile<>(check, store, origin)
                )
            );
        }
    }
}
