package org.jimkast.exotic.bool;

public final class either implements bool {
    private final bool n1;
    private final bool n2;

    public either(bool n1, bool n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public <T> T choose(T left, T right) {
        return n1.choose(true, false) ? left : n2.choose(left, right);
//        return n1.choose(() -> n2.choose(left, right), (Supplier<T>) () -> right).get();
    }
}
