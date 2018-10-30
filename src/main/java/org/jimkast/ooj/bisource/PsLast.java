package org.jimkast.ooj.bisource;

import org.jimkast.ooj.source.Source;
import org.jimkast.ooj.source.PsForEach;
import org.jimkast.ooj.source.PsStore;
import org.jimkast.ooj.target.Ref;

public final class PsLast<T> extends Source.Env<T> {
    public PsLast(Source<T> origin) {
        super(new PsStore<>(new Ref<>(), new PsForEach<>(origin)));
    }
}
