package org.jimkast.eshop.cms;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

public final class TkIndex implements TkXml {

    @Override
    public Source map(HttpServletRequest req) {
        return new StreamSource("file:///C:/Users/jimkast/Desktop/example2.xml");
    }
}
