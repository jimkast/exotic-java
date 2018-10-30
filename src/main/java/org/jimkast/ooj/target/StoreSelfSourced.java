package org.jimkast.ooj.target;

import org.jimkast.ooj.source.PsStore;
import org.jimkast.ooj.source.Source;
import org.jimkast.ooj.source.Store;

public final class StoreSelfSourced<T> extends Store.Env<T> {
    public StoreSelfSourced(Source<T> source, Store<T> origin) {
        super(new Store.DecSource<>(new PsStore<>(origin, source), origin));
    }
}
