package org.jimkast.exotic.possible;

import org.jimkast.exotic.bool.check;
import org.jimkast.exotic.bool.eq;
import org.jimkast.exotic.numberjdk.NumberEnvelope;

public final class indexof<T> extends NumberEnvelope {
    public indexof(T o, possible<T> p) {
        this(t -> new eq(t, o), p);
    }

    public indexof(check<T> check, possible<T> p) {
        super(new count(new pwhile<>(check, p)));
    }
}
