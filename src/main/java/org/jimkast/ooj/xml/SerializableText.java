package org.jimkast.ooj.xml;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.exotic.io.bs.bsource;
import org.jimkast.exotic.text.bstream_1by1;

public final class SerializableText implements bsource {
    private final Row row;

    public SerializableText(Row row) {
        this.row = row;
    }

    @Override
    public void transferTo(OutputStream out) throws IOException {
        new bstream_1by1(Row.CONTENT.consume(row)).transferTo(out);
    }
}
