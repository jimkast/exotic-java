package org.jimkast.exotic.xml.v3;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import org.cactoos.Input;
import org.cactoos.io.InputOf;
import org.jimkast.exotic.io.input.InputIoChecked;
import org.xml.sax.SAXException;

public final class JdkSaxInputSource implements XmlSource {
    private final SAXParser parser;
    private final Input input;

    public JdkSaxInputSource(SAXParser parser, File file) {
        this(parser, new InputOf(file));
    }

    public JdkSaxInputSource(SAXParser parser, Input input) {
        this.parser = parser;
        this.input = input;
    }

    @Override
    public void feed(XmlTarget target) throws IOException {
        try {
            parser.parse(new InputIoChecked(input).stream(), new AsSaxHandler(target));
        } catch (SAXException e) {
            throw new IOException(e);
        }
    }
}
