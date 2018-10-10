package org.jimkast.exotic.text;

import java.util.regex.Pattern;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.bool.bool;

public final class fluent implements binary {
    private final binary origin;

    public fluent(CharSequence origin) {
        this(new of_charseq(origin));
    }

    public fluent(binary origin) {
        this.origin = origin;
    }

    @Override
    public int at(int i) {
        return origin.at(i);
    }

    @Override
    public int length() {
        return origin.length();
    }

    public fluent substring(Number offset) {
        return new fluent(new skipped(offset, origin));
    }

    public fluent substring(Number offset, Number length) {
        return new fluent(new substring(offset, length, origin));
    }

    public fluent substring_after(binary delim) {
        return new fluent(new substring_after(origin, delim));
    }

    public fluent substring_before(binary delim) {
        return new fluent(new substring_before(origin, delim));
    }

    public bool contains(binary delim) {
        return new contains(origin, delim);
    }

    public Number indexOf(binary delim) {
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

    public bool starts_with(binary part) {
        return new starts_with(origin, part);
    }

    public bool ends_with(binary part) {
        return new ends_with(origin, part);
    }

    public fluent trimmed(binary part) {
        return new fluent(new trimmed(origin));
    }

    public fluent trimmed_left(binary part) {
        return new fluent(new trimmed_left(origin));
    }

    public fluent trimmed_right(binary part) {
        return new fluent(new trimmed_right(origin));
    }

    public fluent replaceAll(Pattern regex, String replacement) {
        return new fluent(new of_charseq(regex.matcher(new as_charseq(origin)).replaceAll(replacement)));
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
