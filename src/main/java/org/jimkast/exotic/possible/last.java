package org.jimkast.exotic.possible;

import java.util.List;
import java.util.function.Consumer;
import org.jimkast.exotic.possible.gen.FifoQueue;

public final class last<T> implements possible<T> {
    private final possible<T> origin;

    public last(possible<T> origin) {
        this.origin = new while_present<>(origin);
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
        List<T> store = new FifoQueue<>(1);
        origin.supply(store::add);
        if(!store.isEmpty()) {
            consumer.accept(store.get(0));
        }
    }
}
