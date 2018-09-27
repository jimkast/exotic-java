package org.jimkast.exotic.parse;

import java.io.IOException;
import java.util.Scanner;

public interface scanned_source {
    void consume(Scanner scanner) throws IOException;

}
