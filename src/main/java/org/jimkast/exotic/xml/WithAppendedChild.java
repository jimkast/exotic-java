package org.jimkast.exotic.xml;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.jimkast.exotic.map.FluentMap;

public final class WithAppendedChild implements Node {
    private final Node child;
    private final Node origin;

    public WithAppendedChild(Node child, Node origin) {
        this.child = child;
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
        List<Node> copy = new ArrayList<>(origin.children());
        copy.add(child);
        return Collections.unmodifiableList(copy);
    }

    @Override
    public String name() {
        return origin.name();
    }

    @Override
    public Map<String, Node> attrs() {
        return new FluentMap<>(origin.attrs()).with(child.name(), child);
    }
}
