package org.jimkast.exotic.text.charset;

import java.io.IOException;
import org.jimkast.exotic.binary.bstream;

public interface CsCodec {
    int consume(bstream stream) throws IOException;
}
