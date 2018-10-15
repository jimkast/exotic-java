package org.jimkast.exotic.xml.v3;

import org.jimkast.exotic.text.fixed16;
import org.jimkast.exotic.text.headof;
import org.jimkast.exotic.text.of_charseq;
import org.jimkast.exotic.text.skipped;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public final class AsSaxHandler extends DefaultHandler {
    private final XmlTree tree;

    public AsSaxHandler(XmlTree tree) {
        this.tree = tree;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        tree.startElement(new of_charseq(qName));
        int len = attributes.getLength();
        for (int i = 0; i < len; i++) {
            tree.attr(new of_charseq(attributes.getQName(i)), new of_charseq(attributes.getValue(i)));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        tree.endElement();
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        tree.text(new headof(length, new skipped(start, new fixed16(ch))));
    }
}
