package org.jimkast.ooj.source4;

import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.lang.Quantity;
import org.jimkast.ooj.map.Mapping;

public final class IndexOf<T> extends Source.Env<Integer> implements Quantity {
    public IndexOf(T t, Source<T> s) {
        super(
            new BiFor2<>(
                new BiSource.Filtered1<>(
                    new Check.Eq<>(t),
                    new Combined<>(s, new Range(0, Integer.MAX_VALUE))
                )
            )
        );
    }

    @Override
    public int length() {
        return feed(Mapping.Self.instance(), -1);
    }
}
