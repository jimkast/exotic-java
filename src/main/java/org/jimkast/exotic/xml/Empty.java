package org.jimkast.exotic.xml;

import java.util.Collections;
import java.util.Map;

public final class Empty implements Markup {
    private final String name;

    public Empty(String name) {
        this.name = name;
    }

    @Override
    public String text() {
        return "";
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Map<String, String> attrs() {
        return Collections.emptyMap();
    }

    @Override
    public Map<String, Markup> children() {
        return Collections.emptyMap();
    }

    @Override
    public Markup parent() {
        return null;
    }


}
