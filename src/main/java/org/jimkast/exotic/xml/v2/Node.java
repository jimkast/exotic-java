package org.jimkast.exotic.xml.v2;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

public interface Node {
    void writeText(PrintStream out) throws IOException;

    void serialize(PrintStream out) throws IOException;

    List<Node> children();

    Node parent();

    String name();

    Map<String, Node> attrs();

    NodeType type();
}
