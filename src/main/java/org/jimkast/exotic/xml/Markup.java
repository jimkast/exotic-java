package org.jimkast.exotic.xml;

import java.util.Map;

public interface Markup {
    String text();

    String name();

    Map<String, String> attrs();

    Map<String, Markup> children();

    Markup parent();
}
