package org.jimkast.ooj.source;

import java.util.Iterator;
import org.jimkast.ooj.bisource.BiSource;
import org.jimkast.ooj.bisource.PsBiForEach;
import org.jimkast.ooj.bisource.PsLast;
import org.jimkast.ooj.bisource.PsSize;
import org.jimkast.ooj.bisource.PsWithCounter;
import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.map.Mapping;
import org.jimkast.ooj.source.adapter.PsAsIterator;

public final class PsFluent<T> implements Source<T>, Iterable<T> {
    private final Source<T> origin;

    public PsFluent(Source<T> origin) {
        this.origin = origin;
    }

    public <X> PsFluent<X> map(Mapping<T, X> mapping) {
        return new PsFluent<>(new PsMapped<>(mapping, origin));
    }

    public PsFluent<T> filter(Check<T> filter) {
        return new PsFluent<>(new PsFiltered<>(filter, origin));
    }

    public PsFluent<T> flatten(Source<T> other) {
        return new PsFluent<>(new PsFlattened<>(origin, other));
    }

    public Cond every(Check<T> filter) {
        return new PsMatchAll<>(filter, origin);
    }

    public Cond any(Check<T> filter) {
        return new PsMatchAny<>(filter, origin);
    }

    public PsFluent<T> foreach() {
        return new PsFluent<>(new PsForEach<>(origin));
    }

    public BiSource<T, Integer> fori() {
        return new PsBiForEach<>(new PsWithCounter<>(origin));
    }

    @Override
    public Iterator<T> iterator() {
        return new PsAsIterator<>(origin);
    }

    public PsFluent<T> orelse(Source<T> other) {
        return new PsFluent<>(new PsFallback<>(other, origin));
    }

    public T orelse(T other) {
        return new PsOrElse<>(other).map(origin);
    }

    public PsFluent<T> last() {
        return new PsFluent<>(new PsLast<>(origin));
    }

    public int count() {
        return new PsSize(origin).length();
    }

    public Cond contains(T t) {
        return new PsContains<>(t, origin);
    }

    public Cond containsAll(Source<T> items) {
        return new PsContainsAll<>(items, origin);
    }

    public Cond startsWith(T item) {
        return new PsStartsWith<>(item, origin);
    }

    public Cond endsWith(T item) {
        return new PsEndsWith<>(item, origin);
    }

    @Override
    public void feed(Target<T> target) {
        origin.feed(target);
    }
}
