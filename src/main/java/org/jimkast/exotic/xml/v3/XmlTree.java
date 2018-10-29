package org.jimkast.exotic.xml.v3;

import java.io.IOException;
import javax.xml.stream.XMLStreamConstants;
import com.sun.xml.internal.fastinfoset.stax.StAXDocumentParser;
import org.jimkast.exotic.binary.binary;

public final class XmlTree implements Table, XmlStore {
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
    public void feed(XmlTarget target) throws IOException {
//        for (int i = 0; i < this.i; i++) {
//            int type = types[i];
//            int depth = 0;
//            if(type == StAXDocumentParser.START_ELEMENT && depth == depths[i]) {
//                target.accept(binary.EMPTY, binary.EMPTY, StAXDocumentParser.END_ELEMENT);
//            }
//            switch (type) {
//                case StAXDocumentParser.START_ELEMENT:
//                    target.accept(markup[i], binary.EMPTY, type);
//                    break;
//                case StAXDocumentParser.END_ELEMENT:
//                case StAXDocumentParser.END_DOCUMENT:
//                    parent = parents[i];
//                    depth--;
//                    break;
//                case XMLStreamConstants.ATTRIBUTE:
//                    markup[i] = alpha;
//                    text[i] = beta;
//                    break;
//                case XMLStreamConstants.CHARACTERS:
//                    text[i] = alpha;
//                    break;
//                case XMLStreamConstants.PROCESSING_INSTRUCTION:
//                case XMLStreamConstants.DTD:
//                    markup[i] = alpha;
//                    text[i] = beta;
//                    break;
//            }
//            i++;
//        }
    }

    @Override
    public void accept(binary alpha, binary beta, int type) {
        parents[i] = parent;
        switch (type) {
            case StAXDocumentParser.START_DOCUMENT:
                depths[i] = depth++;
                break;
            case StAXDocumentParser.START_ELEMENT:
                depths[i] = depth++;
                markup[i] = alpha;
                parent = i;
                break;
            case StAXDocumentParser.END_ELEMENT:
            case StAXDocumentParser.END_DOCUMENT:
                parent = parents[i];
                depth--;
                break;
            case XMLStreamConstants.ATTRIBUTE:
                markup[i] = alpha;
                text[i] = beta;
                break;
            case XMLStreamConstants.CHARACTERS:
                text[i] = alpha;
                break;
            case XMLStreamConstants.PROCESSING_INSTRUCTION:
            case XMLStreamConstants.DTD:
                markup[i] = alpha;
                text[i] = beta;
                break;
        }
        i++;
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
