package org.jimkast.exotic.xml.v3;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.junit.Test;

public class XmlTreeTest {

    @Test
    public void parse() throws Exception {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        XmlTree tree = new XmlTree(1000);
        parser.parse(new File("pom.xml"), new AsSaxHandler(tree));
        tree.serialize(System.out);
    }

    @Test
    public void parse2() throws Exception {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        XmlTree tree = new XmlTree(1000);
        parser.parse(new File("pom.xml"), new AsSaxHandler(tree));
    }
}