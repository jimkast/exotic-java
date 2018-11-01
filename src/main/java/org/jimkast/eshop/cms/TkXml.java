package org.jimkast.eshop.cms;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Source;
import org.jimkast.ooj.map.Mapping;

public interface TkXml extends Mapping<HttpServletRequest, Source> {
    @Override
    Source map(HttpServletRequest req);
}
