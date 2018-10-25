package org.jimkast.ooj.bisource;

import org.jimkast.ooj.source.PSource;
import org.jimkast.ooj.source.PsForEach;
import org.jimkast.ooj.source.PsStore;
import org.jimkast.ooj.source.StoreList;

public final class PsLast<T> extends PSource.Env<T> {
    public PsLast(PSource<T> origin) {
        super(new PsStore<>(new StoreList<>(), new PsForEach<>(origin)));
    }
}
