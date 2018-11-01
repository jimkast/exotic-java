package org.jimkast.eshop.cms;

import java.io.OutputStream;
import javax.xml.transform.Source;
import org.jimkast.ooj.bisource.BiTarget;

public interface Xsl extends BiTarget<Source, OutputStream> {
    void accept(Source source, OutputStream out);
}
