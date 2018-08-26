package org.jimkast.exotic.possible;

import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import org.cactoos.Scalar;
import org.cactoos.scalar.UncheckedScalar;
import org.jimkast.exotic.bool.check;
import org.jimkast.exotic.bool.cond;

public final class fluent<T> implements possible<T>, Iterable<T> {
    private final possible<T> origin;

    public fluent(possible<T> origin) {
        this.origin = origin;
    }

    @Override
    public void ifPresent(Consumer<T> consumer) {
        origin.ifPresent(consumer);
    }

    @Override
    public Iterator<T> iterator() {
        return new AsIterator<>(origin);
    }

    public <X> fluent<X> map(Function<T, X> mapper) {
        return new org.jimkast.exotic.possible.fluent<>(new mapped<>(mapper, origin));
    }

    public fluent<T> filter(check<T> check) {
        return new fluent<>(new filtered<>(check, origin));
    }

    public <X> X reduce(X initial, BiFunction<T, X, X> accumulator) {
        return new reduced<>(initial, accumulator, new while_present<>(origin)).value();
    }

    public cond every(check<T> check) {
        return new UncheckedScalar<>(new all<>(check, origin)).value();
    }

    public cond any(check<T> check) {
        return new UncheckedScalar<>(new any<>(check, origin)).value();
    }

    public T orElseGet(Scalar<T> other) throws Exception {
        return new orelse<>(origin, other).value();
    }

    public T orElse(T other) {
        return new UncheckedScalar<>(new orelse<>(origin, other)).value();
    }

    public fluent<T> foreach(Consumer<T> consumer) {
        new while_present<>(origin).ifPresent(consumer);
        return this;
    }

    public fluent<T> foreach(BiConsumer<T, Integer> consumer) {
        new with_index<>(new while_present<>(origin)).foreach(consumer);
        return this;
    }
}
