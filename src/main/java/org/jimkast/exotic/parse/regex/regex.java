package org.jimkast.exotic.parse.regex;

import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.possible.possible;

public interface regex {
    possible<binary> matches(binary b);
}
