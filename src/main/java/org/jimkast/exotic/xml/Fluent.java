package org.jimkast.exotic.xml;

import java.util.Map;

public final class Fluent implements Markup {
    private final Markup origin;

    public Fluent() {
        this(new Document());
    }

    public Fluent(String name) {
        this(new Empty(name));
    }

    public Fluent(Markup origin) {
        this.origin = origin;
    }

    public Fluent append(String name) {
        Markup child = new Empty(name);
        return new Fluent(new WithParent(child, origin));
    }

    public Fluent attr(String name, String value) {
        return new Fluent(new WithAttr(name, value, origin));
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
        return origin.children();
    }

    @Override
    public Markup parent() {
        return origin.parent();
    }
}
