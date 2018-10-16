package org.jimkast.exotic.xml.v3;

import javax.xml.stream.XMLStreamConstants;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.text.fixed16;
import org.jimkast.exotic.text.headof;
import org.jimkast.exotic.text.of_charseq;
import org.jimkast.exotic.text.skipped;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public final class AsSaxHandler extends DefaultHandler {
    private final Target target;

    public AsSaxHandler(Target target) {
        this.target = target;
    }


    @Override
    public void startDocument() throws SAXException {
        target.accept(binary.EMPTY, binary.EMPTY, XMLStreamConstants.START_DOCUMENT);
    }

    @Override
    public void endDocument() throws SAXException {
        target.accept(binary.EMPTY, binary.EMPTY, XMLStreamConstants.END_DOCUMENT);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        target.accept(new of_charseq(qName), binary.EMPTY, XMLStreamConstants.START_ELEMENT);
        int len = attributes.getLength();
        for (int i = 0; i < len; i++) {
            target.accept(new of_charseq(attributes.getQName(i)), new of_charseq(attributes.getValue(i)), XMLStreamConstants.ATTRIBUTE);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        target.accept(new of_charseq(qName), binary.EMPTY, XMLStreamConstants.END_ELEMENT);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        target.accept(new headof(length, new skipped(start, new fixed16(ch))), binary.EMPTY, XMLStreamConstants.CHARACTERS);
    }

    @Override
    public void processingInstruction(String trg, String data) throws SAXException {
        target.accept(new of_charseq(trg), new of_charseq(data), XMLStreamConstants.PROCESSING_INSTRUCTION);
    }
}
