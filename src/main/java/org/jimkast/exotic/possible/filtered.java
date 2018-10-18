package org.jimkast.exotic.possible;

import java.util.function.Consumer;
import org.jimkast.exotic.bool.check;
import org.jimkast.exotic.possible.util.PossibleRunnable;
import org.jimkast.exotic.possible.util.pmapping;

public final class filtered<T> extends possible.env<T> {
    public filtered(check<T> check, possible<T> origin) {
        this(new check.not<>(check), origin, t -> {
        });
    }

    private filtered(check<T> check, possible<T> origin, Consumer<T> empty) {
        super(new pmapping<>(consumer -> new PossibleRunnable<>(new while_present<>(new pwhile<>(check, consumer, origin)), empty)));
    }
}
