package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.target.RefQueue;

public interface CondSource<T> {
    Cond feed(Target<T> target);


    final class Default<T> implements CondSource<T> {
        private final Source<T> source;
        private final RefQueue<T> store = new RefQueue<>();

        public Default(Source<T> source) {
            this.source = source;
        }

        @Override
        public Cond feed(Target<T> target) {
            source.feed(new Target.Both<>(store, target));
            Cond res = store.length() == 0 ? Cond.FALSE : Cond.TRUE;
            store.feed(Target.Noop.instance());
            return res;
        }
    }
}
