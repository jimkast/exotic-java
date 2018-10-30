package org.jimkast.ooj.bisource;

import org.jimkast.exotic.number.add;
import org.jimkast.ooj.source.Source;

public final class PsSums extends Source.Env<Number> {
    public PsSums(Source<Number> origin) {
        super(new PsReduced<>(0, add::new, origin));
    }
}
