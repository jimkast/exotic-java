package org.jimkast.ooj.source;

public final class StoreSelfSourced<T> extends Store.Env<T> {
    public StoreSelfSourced(PSource<T> source, Store<T> origin) {
        super(new Store.DecSource<>(new PsStore<>(origin, source), origin));
    }
}
