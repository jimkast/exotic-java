package org.jimkast.servlet;

import java.util.function.Predicate;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

public final class ChkForPath implements Predicate<HttpServletRequest> {
    private final Predicate<CharSequence> origin;

    public ChkForPath(String ptn) {
        this(new ChkRegex(ptn));
    }

    public ChkForPath(Pattern ptn) {
        this(new ChkRegex(ptn));
    }

    public ChkForPath(Predicate<CharSequence> origin) {
        this.origin = origin;
    }

    @Override
    public boolean test(HttpServletRequest req) {
        return origin.test(req.getRequestURI());
    }
}
