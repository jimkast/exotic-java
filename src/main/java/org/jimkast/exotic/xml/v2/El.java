package org.jimkast.exotic.xml.v2;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class El implements Node {
    private final String name;

    public El(String name) {
        this.name = name;
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
    public void serialize(PrintStream out) throws IOException {
        out.print('<');
        out.print(name());
        for (Map.Entry<String, Node> entry : attrs().entrySet()) {
            out.write(' ');
            entry.getValue().serialize(out);
        }
        for (Node child : children()) {
            child.serialize(out);
        }
        out.print("</");
        out.print(name());
        out.print(">");
    }

    @Override
    public void writeText(PrintStream out) throws IOException {
        for (Node child : children()) {
            child.writeText(out);
        }
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
    public NodeType type() {
        return null;
    }
}
