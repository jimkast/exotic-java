package org.jimkast.ooj.xml;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.exotic.io.bs.bsource;
import org.jimkast.exotic.text.bstream_1by1;

public final class SerializableComment implements bsource {
    private final Row row;

    public SerializableComment(Row row) {
        this.row = row;
    }

    @Override
    public void transferTo(OutputStream out) throws IOException {
        out.write(new byte[]{'<', '!', '-', '-'});
        new bstream_1by1(Row.CONTENT.consume(row)).transferTo(out);
        out.write(new byte[]{'-', '-', '>'});
    }
}
