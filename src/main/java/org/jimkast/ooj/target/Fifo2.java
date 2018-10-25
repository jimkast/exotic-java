package org.jimkast.ooj.target;

import org.jimkast.exotic.numberjdk.Int;
import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.source.PSource;
import org.jimkast.ooj.source.Store;
import org.jimkast.ooj.source.Target;

public final class Fifo2<T> implements Store<T> {
    private final PSource<T> source;
    private final Target<T> target;

    public Fifo2(int size) {
        this(new ObjectArray.Native<>(size), size);
    }

    public Fifo2(ObjectArray<T> arr, int size) {
        this(new FifoStore<>(arr, size), new FifoStore<>(arr, size));
    }

    public Fifo2(PSource<T> source, Target<T> target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public Cond feed(Target<T> target) {
        return source.feed(target);
    }

    @Override
    public void accept(T t) {
        target.accept(t);
    }


    public static final class FifoStore<T> extends Store.Env<T> {
        public FifoStore(ObjectArray<T> arr, int size) {
            super(new ArrRef<>(arr, new AutoIncrCircular(size)));
        }
    }

    public static final class AutoIncr extends Int {
        private int i;

        public AutoIncr() {
            this(0);
        }

        public AutoIncr(int i) {
            this.i = i;
        }

        @Override
        public int intValue() {
            return i++;
        }
    }


    public static final class AutoIncrCircular extends Int {
        private final int size;
        private int i;

        public AutoIncrCircular(int size) {
            this(size, 0);
        }

        public AutoIncrCircular(int size, int i) {
            this.size = size;
            this.i = i;
        }

        @Override
        public int intValue() {
            int temp = i;
            i = (i + 1) % size;
            return temp;
        }
    }
}
