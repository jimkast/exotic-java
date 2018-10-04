package org.jimkast.exotic.xml;

import java.util.LinkedHashMap;
import java.util.Map;

public final class WithParent implements Markup {
    private final Markup parent;
    private final Markup origin;

    public WithParent(Markup parent, Markup origin) {
        this.parent = parent;
        this.origin = origin;
    }

    @Override
    public String text() {
        return origin.text();
    }

    @Override
    public String name() {
        return origin.name();
    }

    @Override
    public Map<String, String> attrs() {
        return origin.attrs();
    }

    @Override
    public Map<String, Markup> children() {
        Map<String, Markup> map = new LinkedHashMap<>(origin.children());
        map.put(parent.name(), parent);
        return map;
    }
}
