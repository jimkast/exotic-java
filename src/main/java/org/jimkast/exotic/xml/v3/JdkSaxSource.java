package org.jimkast.exotic.xml.v3;

import java.io.IOException;
import javax.xml.parsers.SAXParser;
import org.cactoos.Input;
import org.jimkast.exotic.io.input.InputIoChecked;
import org.xml.sax.SAXException;

public final class JdkSaxSource implements Source {
    private final SAXParser parser;
    private final Input input;

    public JdkSaxSource(SAXParser parser, Input input) {
        this.parser = parser;
        this.input = input;
    }

    @Override
    public void feed(Target target) throws IOException {
        try {
            parser.parse(new InputIoChecked(input).stream(), new AsSaxHandler(target));
        } catch (SAXException e) {
            throw new IOException(e);
        }
    }
}
