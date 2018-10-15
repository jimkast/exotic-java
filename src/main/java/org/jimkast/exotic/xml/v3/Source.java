package org.jimkast.exotic.xml.v3;

import java.io.IOException;

public interface Source {
    void feed(Target target) throws IOException;
}
