package org.jimkast.exotic.xml.v3;

import org.jimkast.exotic.binary.binary;

public interface Target {
    void startElement(binary name);

    void endElement();

    void attr(binary name, binary value);

    void text(binary text);

    void comment(binary text);
}
