package org.jimkast.exotic.xml.v3;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.cactoos.iterator.Joined;
import org.cactoos.iterator.Mapped;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.io.bs.bs_input;
import org.jimkast.exotic.text.as_bytestream;
import org.jimkast.exotic.text.of_charseq;
import org.junit.Test;

public class XmlTreeTest {

    @Test
    public void parse() throws Exception {
        new JdkSaxInputSource(SAXParserFactory.newInstance().newSAXParser(), new File("pom.xml"))
            .feed(new TrgSerialize(System.out));
    }

    @Test
    public void parse22() throws Exception {
        XmlTree tree = new XmlTree();
        new JdkSaxInputSource(SAXParserFactory.newInstance().newSAXParser(), new File("pom.xml")).feed(tree);
        tree.feed(new TrgSerialize(System.out));
    }

    @Test
    public void parse2() throws Exception {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        XmlTree tree = new XmlTree(1000);
        parser.parse(new File("pom.xml"), new AsSaxHandler(tree));
    }


    @Test
    public void lexer() throws Exception {
        String s = "GET /bookings?ref=12345 HTTP1/1\r\nHost: www.youtravel.com";
        binary b = new of_charseq(s);
        new bs_input(
            () -> new SequenceInputStream(
                Collections.enumeration(
                    Arrays.asList(
                        new as_bytestream(new of_charseq("<method>")),
                        new as_bytestream(new of_charseq("GET    ")),
                        new as_bytestream(new of_charseq("</method>")),
                        new as_bytestream(new of_charseq(" srgsdrgdg    ")),
                        new as_bytestream(new of_charseq(" 9193929349 2394r3"))
                    )
                )
            )
        ).transferTo(System.out);

    }


    @Test
    public void xdfgxdfg() throws Exception {
        String s = " PT /bookings?ref=12345 HTTP1/1\r\nHost    : www.youtravel.com";
        byte[] bytes = s.getBytes(StandardCharsets.US_ASCII);
        String[] markups = new String[]{"", "method", "uri", "protocol", "name", "value"};
        int[] froms = new int[]{0, 1, 4, 24, 33, 43};
        int[] lengths = new int[]{0, 2, 19, 7, 4, 17};
        new bs_input(() ->
            new SequenceInputStream(
                new IterEnumaration<>(
                    new Joined<>(
                        Arrays.asList(
                            new Mapped<>(
                                i -> new SequenceInputStream(
                                    new IterEnumaration<>(
                                        Arrays.asList(
                                            new ByteArrayInputStream(bytes, froms[i - 1] + lengths[i - 1], froms[i] - froms[i - 1] - lengths[i - 1]),
                                            new ByteArrayInputStream(new byte[]{'<'}),
                                            new ByteArrayInputStream(markups[i].getBytes()),
                                            new ByteArrayInputStream(new byte[]{'>'}),
                                            new ByteArrayInputStream(bytes, froms[i], lengths[i]),
                                            new ByteArrayInputStream(new byte[]{'<', '/'}),
                                            new ByteArrayInputStream(markups[i].getBytes()),
                                            new ByteArrayInputStream(new byte[]{'>'})
                                        ).iterator()
                                    )

                                ),
                                Arrays.asList(1, 2, 3, 4, 5).iterator()
                            ),
                            Collections.<InputStream>singletonList(new ByteArrayInputStream(bytes, froms[froms.length - 1], bytes.length - froms[froms.length - 1])).iterator()
                        )
                    )
                )
            )
        ).transferTo(System.out);
    }
}