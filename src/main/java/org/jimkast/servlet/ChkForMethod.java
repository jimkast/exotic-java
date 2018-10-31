package org.jimkast.servlet;

import java.util.function.Predicate;
import javax.servlet.http.HttpServletRequest;
import org.jimkast.ooj.bool.ChkEq;

public final class ChkForMethod implements Predicate<HttpServletRequest> {
    private final Predicate<CharSequence> origin;

    public ChkForMethod(CharSequence method) {
        this(new ChkEq<>(method));
    }

    public ChkForMethod(Predicate<CharSequence> origin) {
        this.origin = origin;
    }

    @Override
    public boolean test(HttpServletRequest req) {
        return origin.test(req.getMethod());
    }
}
