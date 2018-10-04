package org.jimkast.exotic.bool;

public final class cond_runnable implements Runnable {
    private static final Runnable EMPTY = () -> {
    };
    private final bool cond;
    private final Runnable runnable;

    public cond_runnable(bool cond, Runnable runnable) {
        this.cond = cond;
        this.runnable = runnable;
    }

    @Override
    public void run() {
        cond.choose(runnable, EMPTY).run();
    }
}
