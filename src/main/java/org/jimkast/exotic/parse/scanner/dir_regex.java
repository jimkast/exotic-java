package org.jimkast.exotic.parse.scanner;

import java.util.Scanner;
import java.util.regex.Pattern;
import org.jimkast.exotic.parse.chunk;

public final class dir_regex implements dir {
    public static final dir SP = new dir_regex("\\s+");
    public static final dir NOSP = new dir_regex("\\S+");

    private final Pattern ptn;

    public dir_regex(String ptn) {
        this(Pattern.compile(ptn));
    }

    public dir_regex(Pattern ptn) {
        this.ptn = ptn;
    }

    @Override
    public chunk next(Scanner scanner) {
        return new chunk.str(scanner.next(ptn));
    }
}
