package org.jimkast.ooj.source.ints;

import org.jimkast.ooj.cond.Cond;

public interface IntSource {
    Cond feed(IntTarget target);
}
