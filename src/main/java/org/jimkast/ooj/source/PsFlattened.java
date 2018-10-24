package org.jimkast.ooj.source;

import java.util.Arrays;
import org.jimkast.ooj.lang.Cond;
import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.lang.Target;

public final class PsFlattened<T> implements PSource<T> {
    private final PSource<PSource<T>> sources;
    private PSource<T> current = PSource.Empty.instance();

    @SafeVarargs
    public PsFlattened(PSource<T>... sources) {
        this(new PsOfIterator<>(Arrays.asList(sources).iterator()));
    }

    public PsFlattened(PSource<PSource<T>> sources) {
        this.sources = sources;
    }

    @Override
    public Cond feed(Target<T> target) {
        while (this.current.feed(target).choose(false, true)) {
            if(this.sources.feed(src -> current = src).choose(false, true)) {
                return Cond.FALSE;
            }
        }
        return Cond.TRUE;
    }
}
