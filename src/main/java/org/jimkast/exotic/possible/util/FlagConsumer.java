package org.jimkast.exotic.possible.util;

import java.util.function.Consumer;
import org.jimkast.exotic.bool.bool;

public final class FlagConsumer<T> implements Consumer<T>, bool {
    private final int[] flag;

    public FlagConsumer() {
        this(new int[]{0});
    }

    public FlagConsumer(int flag) {
        this(new int[]{flag});
    }

    public FlagConsumer(int[] flag) {
        this.flag = flag;
    }

    @Override
    public void accept(T t) {
        flag[0] = 1;
    }

    @Override
    public <X> X choose(X left, X right) {
        return flag[0] == 1 ? left : right;
    }

    public void reset() {
        flag[0] = 0;
    }

    public void success() {
        flag[0] = 1;
    }

    public void indeterminate() {
        flag[0] = 2;
    }
}
