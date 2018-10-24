package org.jimkast.ooj.bisource;

import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.lang.Store;
import org.jimkast.ooj.source.PsForEach;
import org.jimkast.ooj.source.PsStore;

public final class PsLast<T> extends PSource.Env<T> {
    public PsLast(PSource<T> origin) {
        super(new PsStore<>(new Store.StoreList<>(), new PsForEach<>(origin)));
    }
}
