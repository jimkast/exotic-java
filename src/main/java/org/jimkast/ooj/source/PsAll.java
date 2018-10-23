package org.jimkast.ooj.source;

import java.util.Arrays;
import org.jimkast.ooj.lang.Cond;
import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.lang.Store;
import org.jimkast.ooj.lang.Target;

public final class PsAll<T> implements PSource<T> {
    private final Store<PSource<T>> store;
    private final PSource<PSource<T>> sources;

    @SafeVarargs
    public PsAll(PSource<T>... sources) {
        this(new PsOfIterator<>(Arrays.asList(sources).iterator()));
    }

    public PsAll(PSource<PSource<T>> sources) {
        this(new Store.StoreList<>(), sources);
    }

    PsAll(Store<PSource<T>> store, PSource<PSource<T>> sources) {
        this.store = store;
        this.sources = sources;
    }

    @Override
    public Cond feed(Target<T> target) {
//        store.feed()
        PSource<PSource<T>> success = trg -> Cond.TRUE;
        PSource<PSource<T>> empty = Empty.instance();
        Target<PSource<T>> noop = Target.Noop.instance();
        Target<PSource<T>> delegated = src -> src.feed(target);
//        Target<PSource<T>> full = src -> src.feed(target)
//            .choose(Empty.<PSource<T>>instance(), sources)
//            .feed(store)
//            .choose(store, Empty.<PSource<T>>instance())
//            .feed(s -> s.feed(target));



        while (store.feed(store).choose(success, sources).feed(store).choose(true, false)) {
        }
        return store.feed(src -> src.feed(target));
    }
}
