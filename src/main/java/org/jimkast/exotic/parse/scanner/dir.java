package org.jimkast.exotic.parse.scanner;

import java.util.Scanner;
import org.jimkast.exotic.parse.chunk;

public interface dir {
    chunk next(Scanner scanner);
}
