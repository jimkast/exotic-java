package org.jimkast.ooj.bisource;

import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.lang.Quantity;
import org.jimkast.ooj.source.OrElse;

public final class PsSize extends Quantity.Env {
    public PsSize(PSource<?>source) {
        super(new OfScalar(new OrElse<>(0, new PsIndices(source))));
    }
}
