package org.jimkast.exotic.xml.v3;

import java.io.IOException;

public interface XmlSource {
    void feed(Target target) throws IOException;
}
