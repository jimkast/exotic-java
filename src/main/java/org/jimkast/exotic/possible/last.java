package org.jimkast.exotic.possible;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class last<T> implements possible<T> {
    private final possible<T> origin;

    public last(possible<T> origin) {
        this.origin = new while_present<>(origin);
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
        List<T> store = new ArrayList<>(1);
        origin.supply(t -> store.add(0, t));
        if(!store.isEmpty()) {
            consumer.accept(store.get(0));
        }
    }
}
