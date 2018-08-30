package org.jimkast.exotic.possible;

import org.jimkast.exotic.bool.bool;
import org.jimkast.exotic.bool.eq;

public final class contains<T> extends bool.env {
    public contains(T o, possible<T> p) {
        super(new eq(0, new indexof<>(o, p)));
    }
}
