package org.jimkast.exotic.xml;

public interface NodeType {
    boolean isText();

    boolean isElement();

    boolean isComment();

    boolean isDocument();

    boolean isAttribute();
}
