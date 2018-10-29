package org.jimkast.ooj.xml;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.exotic.io.bs.bsource;
import org.jimkast.exotic.text.bstream_1by1;
import org.w3c.dom.Node;

public final class SerializableElement implements bsource {
    private final Row row;
    private final Table tbl;

    public SerializableElement(Row row, Table tbl) {
        this.row = row;
        this.tbl = tbl;
    }

    @Override
    public void transferTo(OutputStream out) throws IOException {
        int len = tbl.length();
        out.write('<');
        new bstream_1by1(Row.NAME.consume(row)).transferTo(out);
        Row r;
        int i = Row.INDEX.consume(row) + 1;
        while (Row.TYPE.consume(r = tbl.get(i)) == Node.ATTRIBUTE_NODE && i++ < len) {
            new SerializableAttr(r).transferTo(out);
        }
        if (i == len || (Row.TYPE.consume(r) == Node.TEXT_NODE)) {
            out.write('>');
            new SerializableText(r).transferTo(out);
        } else {
            out.write('/');
            out.write('>');
        }
        out.write(new byte[]{'<', '!', '-', '-'});
        new bstream_1by1(Row.CONTENT.consume(r)).transferTo(out);
        out.write(new byte[]{'-', '-', '>'});
    }
}
