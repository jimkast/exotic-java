package org.jimkast.ooj.source4;

import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.map.BiMapping;

public interface BiSource<X, Y> {
    <Z> Z feed(BiMapping<X, Y, Z> target, Z other);


    class Env<X, Y> implements BiSource<X, Y> {
        private final BiSource<X, Y> origin;

        public Env(BiSource<X, Y> origin) {
            this.origin = origin;
        }

        @Override
        public <Z> Z feed(BiMapping<X, Y, Z> target, Z other) {
            return origin.feed(target, other);
        }
    }

    final class Filtered1<X, Y> implements BiSource<X, Y> {
        private final Check<X> check;
        private final BiSource<X, Y> origin;

        public Filtered1(Check<X> check, BiSource<X, Y> origin) {
            this.check = check;
            this.origin = origin;
        }

        @Override
        public <Z> Z feed(BiMapping<X, Y, Z> target, Z other) {
            return origin.feed((x, y) -> check.test(x).choose(target, (x1, y1) -> other).map(x, y), other);
        }
    }

    final class Filtered2<X, Y> implements BiSource<X, Y> {
        private final Check<Y> check;
        private final BiSource<X, Y> origin;

        public Filtered2(Check<Y> check, BiSource<X, Y> origin) {
            this.check = check;
            this.origin = origin;
        }

        @Override
        public <Z> Z feed(BiMapping<X, Y, Z> target, Z other) {
            return origin.feed((x, y) -> check.test(y).choose(target, (x1, y1) -> other).map(x, y), other);
        }
    }
}
