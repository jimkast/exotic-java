package org.jimkast.exotic.xml;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class El implements Node {
    private final String name;
    private final Map<String, Node> attrs;
    private final List<Node> children;

    public El(String name) {
        this(name, Collections.emptyList());
    }

    public El(String name, Node... children) {
        this(name, Arrays.asList(children));
    }

    public El(String name, List<Node> children) {
        this(name, Collections.emptyMap(), children);
    }

    public El(String name, Map<String, Node> attrs) {
        this(name, attrs, Collections.emptyList());
    }

    public El(String name, Map<String, Node> attrs, Node... children) {
        this(name, attrs, Arrays.asList(children));
    }

    public El(String name, Map<String, Node> attrs, List<Node> children) {
        this.name = name;
        this.attrs = attrs;
        this.children = children;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Map<String, Node> attrs() {
        return attrs;
    }

    @Override
    public void serialize(OutputStream out) throws IOException {
        out.write('<');
        byte[] name = name().getBytes();
        out.write(name);
        for (Map.Entry<String, Node> entry : attrs().entrySet()) {
            out.write(' ');
            entry.getValue().serialize(out);
        }
        List<Node> children = children();
        if (children.isEmpty()) {
            out.write('/');
            out.write('>');
        } else {
            out.write('>');
            for (Node child : children) {
                child.serialize(out);
            }
            out.write('<');
            out.write('/');
            out.write(name);
            out.write('>');
        }
    }

    @Override
    public void writeText(OutputStream out) throws IOException {
        for (Node child : children()) {
            child.writeText(out);
        }
    }


    @Override
    public List<Node> children() {
        return children;
    }
}
