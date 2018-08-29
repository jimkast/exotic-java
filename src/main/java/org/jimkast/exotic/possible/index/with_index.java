package org.jimkast.exotic.possible.index;

import org.jimkast.exotic.numberjdk.as_int;
import org.jimkast.exotic.possible.gen.seq_arithmetic;
import org.jimkast.exotic.possible.combined2;
import org.jimkast.exotic.possible.possible2;
import org.jimkast.exotic.possible.possible;

public final class with_index<T> extends possible2.env<T, Integer> {
    public with_index(possible<T> origin) {
        super(new combined2<>(origin, new as_int(new seq_arithmetic(1))));
    }
}
