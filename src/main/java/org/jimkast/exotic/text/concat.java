package org.jimkast.exotic.text;

import org.cactoos.scalar.UncheckedScalar;
import org.jimkast.exotic.bool.gt;
import org.jimkast.exotic.possible.orelse;
import org.jimkast.exotic.possible.possible;
import org.jimkast.exotic.possible.reduced;
import org.jimkast.exotic.possible.skip_until;

public final class concat implements binary {
    private final possible<binary> all;

    public concat(possible<binary> all) {
        this.all = all;
    }

    @Override
    public int at(int i) {
        return new UncheckedScalar<>(
            new orelse<binary>(
                new skip_until<>(
                    o -> new gt(o.length(), i),
                    all
                ),
                () -> {
                    throw new IndexOutOfBoundsException("Index " + i + " is out of bounds.");
                }
            )
        ).value().at(i);
    }

    @Override
    public int length() {
        return new reduced<>(0, (i, o) -> i + o.length(), all).value();
    }
}
