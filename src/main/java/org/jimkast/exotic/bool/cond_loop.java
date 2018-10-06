package org.jimkast.exotic.bool;

public final class cond_loop implements Runnable {
    private final bool cond;
    private final Runnable runnable;

    public cond_loop(bool cond, Runnable runnable) {
        this.cond = cond;
        this.runnable = runnable;
    }

    @Override
    public void run() {
        while (cond.choose(true, false)) {
            runnable.run();
        }
    }
}
