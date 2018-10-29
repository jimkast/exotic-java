package org.jimkast.ooj.xml;

import java.io.IOException;

public interface XmlSource {
    void feed(XmlTarget target) throws IOException;
}
