package org.jimkast.eshop.cms;

import net.sf.saxon.s9api.BuildingContentHandler;
import org.junit.Test;
import org.xml.sax.helpers.AttributesImpl;

public class SaxonTest {

    @Test
    public void build_doc_programmatically() throws Exception {
        BuildingContentHandler target = Saxon.DOC_BUILDER.newBuildingContentHandler();
        target.startDocument();
        target.startElement("", "root", "root", new AttributesImpl());
        target.characters("123456".toCharArray(), 0, 6);
        target.endElement("", "root", "root");
        target.endDocument();
        System.out.println(target.getDocumentNode().toString());
    }
}