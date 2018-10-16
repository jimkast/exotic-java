package org.jimkast.exotic.xml.v3;

import java.io.PrintStream;
import javax.xml.stream.XMLStreamConstants;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.text.cached;

public final class TrgSerialize implements Target {
    private final PrintStream out;

    public TrgSerialize(PrintStream out) {
        this.out = out;
    }

    @Override
    public void accept(binary alpha, binary beta, int type) {
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
    }

    private void print(binary b) {
        out.print(new cached(b).chars());
    }
}
