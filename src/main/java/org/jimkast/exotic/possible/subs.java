package org.jimkast.exotic.possible;

import org.jimkast.exotic.number.sub;

public final class subs extends possible.env<Number> {
    public subs(possible<Number> origin) {
        super(new reduced2<>(0, sub::new, origin));
    }
}
