package org.jimkast.ooj.source2;

import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.map.Mapping;
import org.jimkast.ooj.source.Target;

public final class TrgFork<T> implements Target<T> {
    private final Mapping<T, Target<T>> mapping;

    public TrgFork(Check<T> chk, Target<T> t1, Target<T> t2) {
        this(key -> chk.test(key).choose(t1, t2));
    }

    public TrgFork(Mapping<T, Target<T>> mapping) {
        this.mapping = mapping;
    }

    @Override
    public void accept(T t) {
        mapping.map(t).accept(t);
    }
}
