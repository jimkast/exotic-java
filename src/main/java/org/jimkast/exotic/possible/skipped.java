package org.jimkast.exotic.possible;

import org.jimkast.exotic.bool.bool;
import org.jimkast.exotic.bool.check;
import org.jimkast.exotic.bool.lte;

public final class skipped<T> extends possible.env<T> {
    public skipped(Number total, possible<T> origin) {
        super(new first<>(
            new counter_check<>(total),
            origin
        ));
    }

    public static final class counter_check<X> implements check<X> {
        private final Number total;
        private int i;

        public counter_check(Number total) {
            this.total = total;
        }

        @Override
        public bool test(X o) {
            return new lte(i++, total);
        }
    }
}
