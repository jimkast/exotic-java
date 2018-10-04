package org.jimkast.exotic.xml;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Collection;
import org.jimkast.exotic.io.bs.bsource;

public final class Serialized implements bsource {
    private final Markup m;

    public Serialized(Markup m) {
        this.m = m;
    }

    @Override
    public void transferTo(OutputStream out) throws IOException {
        PrintStream p = new PrintStream(out);
        p.print('<');
        p.print(m.name());
        m.attrs().forEach((key, value) -> {
            p.print(' ');
            p.print(key);
            p.print('=');
            p.print('"');
            p.print(value);
            p.print('"');
        });
        Collection<Markup> values = m.children().values();
        if (values.isEmpty()) {
            p.print("/>");
        } else {
            p.print('>');
            for (Markup value : values) {
                new Serialized(value).transferTo(out);
            }
        }

    }
}
