package org.jimkast.exotic.xml.v3;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.exotic.io.bs.bsource;
import org.jimkast.exotic.text.bstream_1by1;

public final class SerializableAttr implements bsource {
    private final Row row;

    public SerializableAttr(Row row) {
        this.row = row;
    }

    @Override
    public void transferTo(OutputStream out) throws IOException {
        out.write(' ');
        new bstream_1by1(Row.NAME.consume(row)).transferTo(out);
        out.write('=');
        out.write('"');
        new bstream_1by1(Row.CONTENT.consume(row)).transferTo(out);
        out.write('"');
    }
}
