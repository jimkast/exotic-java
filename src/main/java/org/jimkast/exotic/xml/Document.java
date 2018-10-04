package org.jimkast.exotic.xml;

import java.util.Collections;
import java.util.Map;

public final class Document implements Markup {
    @Override
    public String text() {
        return "";
    }

    @Override
    public String name() {
        return "";
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
        return this;
    }
}
