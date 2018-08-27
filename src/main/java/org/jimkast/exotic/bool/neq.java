package org.jimkast.exotic.bool;

public final class neq extends bool.env {
    public neq(Object n1, Object n2) {
        super(new not(new eq(n1, n2)));
    }
}
