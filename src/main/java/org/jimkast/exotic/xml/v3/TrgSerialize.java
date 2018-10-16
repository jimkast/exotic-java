package org.jimkast.exotic.xml.v3;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UncheckedIOException;
import javax.xml.stream.XMLStreamConstants;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.text.bstream_1by1;

public final class TrgSerialize implements Target {
    private final PrintStream out;

    public TrgSerialize(PrintStream out) {
        this.out = out;
    }

    @Override
    public void accept(binary alpha, binary beta, int type) {
        try {
            switch (type) {
                case XMLStreamConstants.START_DOCUMENT:
                    if (alpha.length() > 0) {
                        out.print("<?xml ");
                        print(alpha);
                        out.print("?>\n");
                    }
                    break;
                case XMLStreamConstants.START_ELEMENT:
                    out.print("<");
                    print(alpha);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    out.print("</");
                    print(alpha);
                    out.print(">");
                    break;
                case XMLStreamConstants.END_DOCUMENT:
                    break;
                case XMLStreamConstants.ATTRIBUTE:
                    out.print(' ');
                    print(alpha);
                    out.print('"');
                    print(beta);
                    out.print('"');
                    break;
                case XMLStreamConstants.CHARACTERS:
                    print(alpha);
                    break;
                case XMLStreamConstants.PROCESSING_INSTRUCTION:
                    out.print("<?");
                    print(alpha);
                    print(beta);
                    out.print("?>");
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private void print(binary b) throws IOException {
        new bstream_1by1(b).transferTo(out);
    }
}
