package org.jimkast.exotic.xml;

import java.io.IOException;
import java.io.OutputStream;
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
    public void writeText(OutputStream out) throws IOException {
        out.write(value.getBytes());
    }

    @Override
    public void serialize(OutputStream out) throws IOException {
        out.write(name.getBytes());
        out.write('=');
        out.write('\"');
        out.write(value.getBytes());
        out.write('"');
    }

    @Override
    public List<Node> children() {
        return Collections.emptyList();
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Map<String, Node> attrs() {
        return Collections.emptyMap();
    }
}
