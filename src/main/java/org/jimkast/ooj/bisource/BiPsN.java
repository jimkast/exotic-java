package org.jimkast.ooj.bisource;

import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.lang.Array;
import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.source.PSource;
import org.jimkast.ooj.source.Target;
import org.jimkast.ooj.target.Queue;

public final class BiPsN<T> implements PSource<Array<T>> {
    private final Check<Integer> check;
    private final ArrayTarget<T> arr;
    private final PSource<T> origin;

    @SafeVarargs
    public BiPsN(PSource<T> origin, T... t) {
        this(new Check.Eq<>(t.length + 1), new Queue<>(t), origin);
    }

    public BiPsN(Check<Integer> check, ArrayTarget<T> arr, PSource<T> origin) {
        this.check = check;
        this.arr = arr;
        this.origin = origin;
    }

    @Override
    public Cond feed(Target<Array<T>> target) {
        origin.feed(arr);
        return check.test(arr.length()).choose(new CondAccept<>(target, arr, Cond.TRUE), Cond.FALSE);
    }


    public static final class CondAccept<T> implements Cond {
        private final Target<T> target;
        private final T item;
        private final Cond origin;

        public CondAccept(Target<T> target, T item, Cond origin) {
            this.target = target;
            this.item = item;
            this.origin = origin;
        }

        @Override
        public <X> X choose(X main, X other) {
            target.accept(item);
            return origin.choose(main, other);
        }
    }
}
