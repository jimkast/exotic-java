package org.jimkast.exotic.text;

import org.jimkast.exotic.bool.bool;

public final class eq_casei extends bool.env {
    public eq_casei(text t1, text t2) {
        super(new eq(new uppercase(t1), new uppercase(t2)));
    }
}
