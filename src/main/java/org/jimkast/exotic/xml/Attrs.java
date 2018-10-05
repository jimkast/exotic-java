package org.jimkast.exotic.xml;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jimkast.exotic.map.MapWrap;

public final class Attrs extends MapWrap<String, Node> {
    public Attrs(Node... attrs) {
        this(Arrays.asList(attrs));
    }

    public Attrs(Iterable<Node> attrs) {
        this(attrs, new LinkedHashMap<>());
    }

    public Attrs(Iterable<Node> attrs, Map<String, Node> map) {
        super(map);
        for (Node attr : attrs) {
            map.put(attr.name(), attr);
        }
    }

    public Attrs(Map<String, Node> map) {
        super(map);
    }

    public Attrs with(Node node) {
        put(node.name(), node);
        return this;
    }

    public Attrs attr(String name, String value) {
        return with(new Attr(name, value));
    }
}
