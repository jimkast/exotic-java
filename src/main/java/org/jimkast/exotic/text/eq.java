package org.jimkast.exotic.text;

import org.jimkast.exotic.bool.bool;

public final class eq implements bool {
    private final text t1, t2;

    public eq(text t1, text t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    @Override
    public <T> T choose(T left, T right) {
        int len = t1.length();
        if (len != t2.length()) {
            return right;
        }
        int i = 0;
        while (i < len) {
            if (t1.at(i) != t2.at(i)) {
                return right;
            }
            i++;
        }
        return left;
    }
}
