package org.jimkast.servlet;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public final class ChkRegex implements Predicate<CharSequence> {
    private final Pattern ptn;

    public ChkRegex(String ptn) {
        this(Pattern.compile(ptn, Pattern.DOTALL | Pattern.CASE_INSENSITIVE));
    }

    public ChkRegex(Pattern ptn) {
        this.ptn = ptn;
    }

    @Override
    public boolean test(CharSequence charSequence) {
        return ptn.matcher(charSequence).matches();
    }
}
