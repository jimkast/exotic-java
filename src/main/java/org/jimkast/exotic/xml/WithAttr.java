package org.jimkast.exotic.xml;

import java.util.LinkedHashMap;
import java.util.Map;

public final class WithAttr implements Markup {
    private final String key;
    private final String value;
    private final Markup origin;

    public WithAttr(String key, String value, Markup origin) {
        this.key = key;
        this.value = value;
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
        Map<String, String> map = new LinkedHashMap<>(origin.attrs());
        map.put(key, value);
        return map;
    }

    @Override
    public Map<String, Markup> children() {
        return origin.children();
    }

    @Override
    public Markup parent() {
        return null;
    }
}
