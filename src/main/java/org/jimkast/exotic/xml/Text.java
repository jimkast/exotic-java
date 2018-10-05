package org.jimkast.exotic.xml;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.cactoos.io.InputOf;
import org.jimkast.exotic.io.bs.bs_input;
import org.jimkast.exotic.io.bs.bsource;

public final class Text implements Node {
    private final bsource text;

    public Text(String text) {
        this(new bs_input(new InputOf(text)));
    }

    public Text(bsource text) {
        this.text = text;
    }

    @Override
    public void writeText(OutputStream out) throws IOException {
        text.transferTo(out);
    }

    @Override
    public void serialize(OutputStream out) throws IOException {
        text.transferTo(out);
    }

    @Override
    public List<Node> children() {
        return Collections.emptyList();
    }

    @Override
    public String name() {
        return "";
    }

    @Override
    public Map<String, Node> attrs() {
        return Collections.emptyMap();
    }
}
