package org.jimkast.exotic.possible;

import org.jimkast.exotic.bool.bool;
import org.jimkast.exotic.bool.check;
import org.jimkast.exotic.bool.not;

public final class all<T> extends bool.env {
    public all(check<T> check, possible<T> possible) {
        super(new not(new any<>(new check.not<>(check), possible)));
    }
}
