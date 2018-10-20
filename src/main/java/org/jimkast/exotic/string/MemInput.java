package org.jimkast.exotic.string;

import java.io.IOException;
import org.jimkast.exotic.net.OutStream;

public interface MemInput {
    void printTo(OutStream out, int offset, int length) throws IOException;
}
