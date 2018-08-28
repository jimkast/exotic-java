package org.jimkast.exotic.possible.gen;

import org.jimkast.exotic.numberjdk.NumberEnvelope;
import org.jimkast.exotic.possible.possible;

public final class count extends NumberEnvelope {
    public count(possible<?> p) {
        super(new gen1<>(0, i -> i + 1));
    }
}
