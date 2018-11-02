package org.jimkast.ooj.source;

import java.util.Arrays;

public final class PsFlattenedSingle<T> implements Source<T> {
    private final Source<Source<T>> source;

    @SafeVarargs
    public PsFlattenedSingle(Source<T>... sources) {
        this(new PsOfIterator<>(Arrays.asList(sources).iterator()));
    }

    public PsFlattenedSingle(Source<Source<T>> source) {
        this.source = source;
    }

    @Override
    public void feed(Target<T> target) {
        source.feed(new TrgFlattened<>(target));
    }


    public static final class TrgFlattened<T> implements Target<Source<T>> {
        private final Target<T> origin;

        public TrgFlattened(Target<T> origin) {
            this.origin = origin;
        }

        @Override
        public void accept(Source<T> source) {
            source.feed(origin);
        }
    }
}
