package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.lang.Quantity;
import org.jimkast.ooj.target.Ref;

public interface CondSource<T> {
    Cond feed(Target<T> target);


    final class Default<T> implements CondSource<T> {
        private final Source<T> source;

        public Default(Source<T> source) {
            this.source = source;
        }

        @Override
        public Cond feed(Target<T> target) {
            Ref<T> ref = new Ref<>();
            source.feed(new Target.Both<>(ref, target));
            return new Quantity.NotEmpty<>(ref);
        }
    }
}
