package org.jimkast.exotic.xml.v3;

import org.jimkast.exotic.text.fixed16;
import org.jimkast.exotic.text.headof;
import org.jimkast.exotic.text.of_charseq;
import org.jimkast.exotic.text.skipped;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public final class AsSaxHandler extends DefaultHandler {
    private final Target target;

    public AsSaxHandler(Target target) {
        this.target = target;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        target.startElement(new of_charseq(qName));
        int len = attributes.getLength();
        for (int i = 0; i < len; i++) {
            target.attr(new of_charseq(attributes.getQName(i)), new of_charseq(attributes.getValue(i)));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        target.endElement();
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        target.text(new headof(length, new skipped(start, new fixed16(ch))));
    }
}
