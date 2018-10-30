package org.jimkast.ooj.bisource;

import org.jimkast.ooj.lang.Quantity;
import org.jimkast.ooj.source.PsOrElse;
import org.jimkast.ooj.source.Source;
import org.jimkast.ooj.source.ScalarMapping;

public final class PsSize extends Quantity.Env {
    public PsSize(Source<?> source) {
        this(0 , source);
    }


    public PsSize(int orelse, Source<?> source) {
        super(new OfScalar(
            new ScalarMapping<>(
                new PsLast<>(new PsIndices(source)),
                new PsOrElse<>(orelse)
            )
        ));
    }
}
