package org.jimkast.exotic.xml;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public final class FluentXml implements Node {
    private final Node origin;

    public FluentXml(String name) {
        this(new El(name));
    }

    public FluentXml(Node origin) {
        this.origin = origin;
    }

    public FluentXml attr(String name, String value) {
        return new FluentXml(new WithAttr(name, value, origin));
    }

    public FluentXml prepend(Node child) {
        return new FluentXml(new WithPrependedChild(child, origin));
    }

    public FluentXml append(Node child) {
        return new FluentXml(new WithAppendedChild(child, origin));
    }

    @Override
    public void writeText(OutputStream out) throws IOException {
        origin.writeText(out);
    }

    @Override
    public void serialize(OutputStream out) throws IOException {
        origin.serialize(out);
    }

    @Override
    public List<Node> children() {
        return origin.children();
    }

    @Override
    public String name() {
        return origin.name();
    }

    @Override
    public Map<String, Node> attrs() {
        return origin.attrs();
    }
}
