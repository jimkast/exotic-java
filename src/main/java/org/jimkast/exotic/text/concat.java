package org.jimkast.exotic.text;

import java.util.function.Function;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.binary.blength;
import org.jimkast.exotic.bool.gt;
import org.jimkast.exotic.numberjdk.Int;
import org.jimkast.exotic.numberjdk.NumberEnvelope;
import org.jimkast.exotic.possible.mapped;
import org.jimkast.exotic.possible.orelse;
import org.jimkast.exotic.possible.possible;
import org.jimkast.exotic.possible.reduced;
import org.jimkast.exotic.possible.skip_until;

public final class concat implements binary {
    private final Function<Number, Number> at;
    private final Number length;

    public concat(possible<binary> all) {
        this(
            i -> new NumberEnvelope(
                new orelse<>(
                    new mapped<>(
                        b -> b.at(i.intValue()),
                        new skip_until<>(
                            b -> new gt(new blength(b), i),
                            all
                        )
                    ),
                    new Int() {
                        @Override
                        public int intValue() {
                            throw new IndexOutOfBoundsException("Index " + i + " is out of bounds.");
                        }
                    }
                )
            ),
            new NumberEnvelope(new reduced<>(0, (i, o) -> i + o.length(), all))
        );

    }

    public concat(Function<Number, Number> at, Number length) {
        this.at = at;
        this.length = length;
    }

    @Override
    public int at(int i) {
        return at.apply(i).intValue();
    }

    @Override
    public int length() {
        return length.intValue();
    }
}
