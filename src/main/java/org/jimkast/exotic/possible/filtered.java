package org.jimkast.exotic.possible;

import org.jimkast.exotic.bool.check;

public final class filtered<T> extends possible.env<T> {
    public filtered(check<T> check, possible<T> origin) {
        super(new skip_until<>(check, origin));
    }
}
