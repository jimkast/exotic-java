package org.jimkast.exotic.possible;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import org.cactoos.Scalar;
import org.cactoos.scalar.UncheckedScalar;
import org.jimkast.exotic.bool.bool;
import org.jimkast.exotic.bool.check;
import org.jimkast.exotic.possible.adapter.AsIterator;
import org.jimkast.exotic.possible.index.with_index;

public final class fluent<T> implements possible<T>, Iterable<T> {
    private final possible<T> origin;

    public fluent(possible<T> origin) {
        this.origin = origin;
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
        origin.supply(consumer);
    }

    @Override
    public Iterator<T> iterator() {
        return new AsIterator<>(origin);
    }

    public <X> fluent<X> map(Function<T, X> mapper) {
        return new fluent<>(new mapped<>(mapper, origin));
    }

    public fluent<T> filter(check<T> check) {
        return new fluent<>(new filtered<>(check, origin));
    }

    public <X> X reduced(X initial, BiConsumer<X, T> accumulator) {
        return reduce(initial, (x, t) -> {
            accumulator.accept(x, t);
            return x;
        });
    }

    public <X> X reduce(X initial, BiFunction<X, T, X> accumulator) {
        return new reduced<>(initial, accumulator, new while_present<>(origin)).value();
    }

    public bool every(check<T> check) {
        return new all<>(check, origin);
    }

    public bool any(check<T> check) {
        return new any<>(check, origin);
    }

    public fluent<T> flatmap(possible<T> other) {
        return new fluent<>(new joined<>(this, other));
    }

    public T orelse(Scalar<T> other) throws Exception {
        return new orelse<>(origin, other).value();
    }

    public T orelse(T other) {
        return new UncheckedScalar<>(new orelse<>(origin, other)).value();
    }

    public fluent<T> foreach(Consumer<T> consumer) {
        new while_present<>(origin).supply(consumer);
        return this;
    }

    public fluent<T> foreach(BiConsumer<T, Integer> consumer) {
        new with_index<>(new while_present<>(origin)).supply(consumer);
        return this;
    }

    public fluent<T> sorted(Comparator<T> cmp) {
        return new fluent<>(new sorted<>(cmp, origin));
    }

    public fluent<T> sorted() {
        return new fluent<>(new sorted<>(origin));
    }

    public fluent<T> limited(Number max) {
        return new fluent<>(new limited<>(max, origin));
    }

    public fluent<T> skipped(Number count) {
        return new fluent<>(new skipped<>(count, origin));
    }

    public fluent<T> first(Number count) {
        return new fluent<>(new skipped<>(count, origin));
    }

    public long count() {
        return new count(origin).longValue();
    }

    public fluent<T> sticky() {
        return new fluent<>(new sticky<>(origin));
    }
}
