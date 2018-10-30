package org.jimkast.ooj.bisource;

import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.lang.Array;
import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.source.Source;
import org.jimkast.ooj.source.Target;
import org.jimkast.ooj.target.Queue;

public final class BiPsN<T> implements Source<Array<T>> {
    private final Check<Integer> check;
    private final ArrayTarget<T> arr;
    private final Source<T> origin;

    @SafeVarargs
    public BiPsN(Source<T> origin, T... t) {
        this(new Check.Eq<>(t.length), new Queue<>(t), origin);
    }

    public BiPsN(Check<Integer> check, ArrayTarget<T> arr, Source<T> origin) {
        this.check = check;
        this.arr = arr;
        this.origin = origin;
    }

    @Override
    public void feed(Target<Array<T>> target) {
        origin.feed(arr);
        check.test(arr.length()).<Target<Array<T>>>choose(target, Target.Noop.instance()).accept(arr);
    }
}
