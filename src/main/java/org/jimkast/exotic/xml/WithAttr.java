package org.jimkast.exotic.xml;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import org.jimkast.exotic.map.FluentMap;

public final class WithAttr implements Node {
    private final Node attr;
    private final Node origin;

    public WithAttr(String name, String value, Node origin) {
        this(new Attr(name, value), origin);
    }

    public WithAttr(Node attr, Node origin) {
        this.attr = attr;
        this.origin = origin;
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
        return new FluentMap<>(origin.attrs()).with(attr.name(), attr);
    }
}
