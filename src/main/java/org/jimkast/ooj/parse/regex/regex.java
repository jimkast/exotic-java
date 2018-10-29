package org.jimkast.ooj.parse.regex;

import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.possible.possible;

public interface regex {
    possible<binary> matches(binary b);
}
