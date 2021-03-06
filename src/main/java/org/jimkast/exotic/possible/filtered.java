package org.jimkast.exotic.possible;

import java.util.function.Consumer;
import org.jimkast.exotic.bool.check;
import org.jimkast.exotic.possible.util.PossibleAsRunnable;
import org.jimkast.exotic.possible.util.pmapping;

public final class filtered<T> extends possible.env<T> {
    public filtered(check<T> check, possible<T> origin) {
        this(new check.not<>(check), origin, t -> {
        });
    }

    private filtered(check<T> check, possible<T> origin, Consumer<? super T> empty) {
        super(new pmapping<>(consumer -> new PossibleAsRunnable<>(new while_present<>(new pwhile<>(check, origin, consumer)), empty)));
    }
}
