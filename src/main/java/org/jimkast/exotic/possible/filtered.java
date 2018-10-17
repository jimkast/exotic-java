package org.jimkast.exotic.possible;

import org.jimkast.exotic.bool.check;
import org.jimkast.exotic.possible.util.pmapping;

public final class filtered<T> extends possible.env<T> {
    public filtered(check<T> check, possible<T> origin) {
        super(new pmapping<>(
            consumer -> () -> new while_present<>(
                new pwhile<>(
                    new check.not<>(check),
                    consumer, origin
                )
            ).supply(t -> {
            })
        ));
    }
}
