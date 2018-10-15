package org.jimkast.exotic.xml.v3;

import java.io.PrintStream;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.text.cached;
import org.w3c.dom.Node;

public final class XmlTree implements Table, Target {
    private final int[] parents;
    private final byte[] types;
    private final byte[] depths;
    private final binary[] markup;
    private final binary[] text;
    private byte depth = 0;
    private int i = 0;
    private int parent = -1;

    public XmlTree() {
        this(100);
    }

    public XmlTree(int size) {
        this(new int[size], new byte[size], new byte[size], new binary[size], new binary[size]);
    }

    public XmlTree(int[] parents, byte[] types, byte[] depths, binary[] markup, binary[] text) {
        this.parents = parents;
        this.depths = depths;
        this.markup = markup;
        this.text = text;
        this.types = types;
    }

    @Override
    public Row get(int i) {
        return new TreeRow(i, this);
    }

    @Override
    public int length() {
        return i;
    }

    @Override
    public void startElement(binary name) {
        parents[i] = parent;
        markup[i] = name;
        text[i] = binary.EMPTY;
        depths[i] = depth++;
        parent = i++;
    }

    @Override
    public void endElement() {
        parent = parents[i];
        depth--;
    }

    @Override
    public void attr(binary name, binary value) {
        parents[i] = parent;
        types[i] = Node.ATTRIBUTE_NODE;
        markup[i] = name;
        text[i] = value;
        i++;
    }

    @Override
    public void text(binary text) {
        parents[i] = parent;
        types[i] = Node.TEXT_NODE;
        markup[i] = binary.EMPTY;
        this.text[i] = text;
        i++;
    }

    @Override
    public void comment(binary text) {
        parents[i] = parent;
        types[i] = Node.COMMENT_NODE;
        this.text[i] = text;
        markup[i] = binary.EMPTY;
        i++;
    }

    public void serialize(PrintStream out) {
        for (int j = 0; j < i; j++) {
            if (types[j] == 0) {
                out.print('<');
                out.print(new cached(markup[j]).chars());
            } else if (types[j] == Node.ATTRIBUTE_NODE) {
                out.print(' ');
                out.print(new cached(markup[j]).chars());
                out.print('=');
                out.print(new cached(text[j]).chars());
            } else if (types[j] == Node.TEXT_NODE) {
                out.print(new cached(text[j]).chars());
            } else if (types[j] == Node.COMMENT_NODE) {
                out.print("<!--");
                out.print(new cached(text[j]).chars());
                out.print("-->");
            }
        }
    }


    public static final class TreeRow implements Row {
        private final int index;
        private final XmlTree tree;

        public TreeRow(int index, XmlTree tree) {
            this.index = index;
            this.tree = tree;
        }

        @Override
        public int single(int i) {
            switch (i) {
                case 0:
                    return index;
                case 1:
                    return tree.parents[i];
                case 2:
                    return tree.types[i];
            }
            return -1;
        }

        @Override
        public binary binary(int i) {
            switch (i) {
                case 4:
                    return tree.markup[i];
                case 5:
                    return tree.text[i];
            }
            return binary.EMPTY;
        }

        @Override
        public int length() {
            return 5;
        }
    }
}
