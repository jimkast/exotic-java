package org.jimkast.eshop.cms;

import javax.xml.transform.Source;

public interface SaxonXsl {
    SaxonSource apply(Source source);
}
