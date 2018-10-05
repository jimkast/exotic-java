package org.jimkast.exotic.xml;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public interface Node {
    void writeText(OutputStream out) throws IOException;

    void serialize(OutputStream out) throws IOException;

    List<Node> children();

    String name();

    Map<String, Node> attrs();
}
