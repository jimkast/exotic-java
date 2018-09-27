package org.jimkast.exotic.parse.scanner;

import java.util.Scanner;
import java.util.regex.Pattern;
import org.jimkast.exotic.parse.chunk;

public final class delimited implements dir {
    private final Pattern delim;
    private final dir d;

    public delimited(String delim, dir d) {
        this(Pattern.compile(delim), d);
    }

    public delimited(Pattern delim, dir d) {
        this.delim = delim;
        this.d = d;
    }

    @Override
    public chunk next(Scanner scanner) {
        return d.next(scanner.useDelimiter(delim));
    }
}
