package org.jimkast.exotic.possible;

import java.util.function.Consumer;
import java.util.function.Function;
import org.cactoos.Scalar;
import org.jimkast.exotic.bool.check;

public final class first<T> implements possible<T> {
    private final check<T> check;
    private final possible<T> origin;

    public first(check<T> check, T item) {
        this(check, () -> item);
    }

    public first(check<T> check, T initial, Function<T, T> next) {
        this(check, new gen<>(initial, next));
    }

    public first(check<T> check, Scalar<T> scalar) {
        this(check, new fixed<>(scalar));
    }

    public first(check<T> check, possible<T> origin) {
        this.check = check;
        this.origin = origin;
    }

    @Override
    public void ifPresent(Consumer<T> consumer) {
        origin.ifPresent(t -> {
            check.test(t).choose(consumer, t1 -> {}).accept(t);
            ifPresent(consumer);
        });
    }
}
