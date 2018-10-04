package org.jimkast.exotic.xml.v2;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class Attr implements Node {
    private final String name;
    private final String value;

    public Attr(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public void writeText(PrintStream out) throws IOException {
        out.print(value);
    }

    @Override
    public void serialize(PrintStream out) throws IOException {
        out.print(name);
        out.print("=\"");
        out.print(value);
        out.print("\"");
    }

    @Override
    public List<Node> children() {
        return Collections.emptyList();
    }

    @Override
    public Node parent() {
        return null;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Map<String, Node> attrs() {
        return Collections.emptyMap();
    }

    @Override
    public NodeType type() {
        return null;
    }
}
