package org.jimkast.exotic.xml.v3;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
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
}