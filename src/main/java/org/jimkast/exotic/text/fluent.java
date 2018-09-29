package org.jimkast.exotic.text;

import java.util.regex.Pattern;
import org.jimkast.exotic.bool.bool;

public final class fluent implements text {
    private final text origin;

    public fluent(CharSequence origin) {
        this(new text.of(origin));
    }

    public fluent(text origin) {
        this.origin = origin;
    }

    @Override
    public char at(int i) {
        return origin.at(i);
    }

    @Override
    public int length() {
        return origin.length();
    }

    public fluent substring(Number offset) {
        return new fluent(new substring(origin, offset));
    }

    public fluent substring(Number offset, Number length) {
        return new fluent(new substring(origin, offset, length));
    }

    public fluent substring_after(text delim) {
        return new fluent(new substring_after(origin, delim));
    }

    public fluent substring_before(text delim) {
        return new fluent(new substring_before(origin, delim));
    }

    public bool contains(text delim) {
        return new contains(origin, delim);
    }

    public Number indexOf(text delim) {
        return new indexof(origin, delim);
    }

    public Number indexOf(char delim) {
        return new chindex(origin, delim);
    }

    public fluent uppercase() {
        return new fluent(new uppercase(origin));
    }

    public fluent lowercase() {
        return new fluent(new lowercase(origin));
    }

    public bool starts_with(text part) {
        return new starts_with(origin, part);
    }

    public bool ends_with(text part) {
        return new ends_with(origin, part);
    }

    public fluent trimmed(text part) {
        return new fluent(new trimmed(origin));
    }

    public fluent trimmed_left(text part) {
        return new fluent(new trimmed_left(origin));
    }

    public fluent trimmed_right(text part) {
        return new fluent(new trimmed_right(origin));
    }

    public fluent replaceAll(Pattern regex, String replacement) {
        return new fluent(new of(regex.matcher(new as_charseq(origin)).replaceAll(replacement)));
    }

    public bool matches(String regex) {
        return matches(Pattern.compile(regex));
    }

    public bool matches(Pattern regex) {
        return new bool.ofbool(() -> regex.matcher(new as_charseq(origin)).matches());
    }

    public char[] chars() {
        return new cached(origin).chars();
    }
}
