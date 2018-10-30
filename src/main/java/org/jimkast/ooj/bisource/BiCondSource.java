package org.jimkast.ooj.bisource;

import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.target.Ref;

public interface BiCondSource<X, Y> {
    Cond feed(BiTarget<X, Y> target);

    final class Default<X, Y> implements BiCondSource<X, Y> {
        private final BiSource<X, Y> source;

        public Default(BiSource<X, Y> source) {
            this.source = source;
        }

        @Override
        public Cond feed(BiTarget<X, Y> target) {
            Ref<X> ref = new Ref<>();
            source.feed((x, y) -> {
                ref.accept(x);
                target.accept(x, y);
            });
            return ref.length() == 0 ? Cond.FALSE : Cond.TRUE;
        }
    }
}
