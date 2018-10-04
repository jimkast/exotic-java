package org.jimkast.exotic.xml.v2;

public interface NodeType {
    boolean isText();

    boolean isElement();

    boolean isComment();

    boolean isDocument();

    boolean isAttribute();
}
