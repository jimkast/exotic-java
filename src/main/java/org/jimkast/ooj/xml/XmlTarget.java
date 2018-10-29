package org.jimkast.ooj.xml;

import javax.xml.stream.XMLStreamConstants;
import org.jimkast.exotic.binary.binary;

public interface XmlTarget {
    void accept(binary alpha, binary beta, int type);


    final class Fluent implements XmlTarget {
        private final XmlTarget origin;

        public Fluent(XmlTarget origin) {
            this.origin = origin;
        }

        public Fluent startElement(binary text) {
            origin.accept(text, binary.EMPTY, XMLStreamConstants.START_ELEMENT);
            return this;
        }

        public Fluent endElement(binary text) {
            origin.accept(text, binary.EMPTY, XMLStreamConstants.END_ELEMENT);
            return this;
        }

        public Fluent attr(binary name, binary value) {
            origin.accept(name, value, XMLStreamConstants.ATTRIBUTE);
            return this;
        }

        public Fluent text(binary text) {
            origin.accept(text, binary.EMPTY, XMLStreamConstants.CHARACTERS);
            return this;
        }

        public Fluent pi(binary name, binary value) {
            origin.accept(name, value, XMLStreamConstants.PROCESSING_INSTRUCTION);
            return this;
        }

        @Override
        public void accept(binary alpha, binary beta, int type) {
            origin.accept(alpha, beta, type);
        }
    }
}
