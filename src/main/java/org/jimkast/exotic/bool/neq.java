package org.jimkast.exotic.bool;

public final class neq extends cond.env {
    public neq(Object n1, Object n2) {
        super(new not(new eq(n1, n2)));
    }
}
