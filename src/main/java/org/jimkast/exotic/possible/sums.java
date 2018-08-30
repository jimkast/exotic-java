package org.jimkast.exotic.possible;

import org.jimkast.exotic.number.add;

public final class sums extends possible.env<Number> {
    public sums(possible<Number> origin) {
        super(new reduced2<>(0, add::new, origin));
    }
}
