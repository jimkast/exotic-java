package org.jimkast.eshop.cms;

import net.sf.saxon.s9api.Destination;
import net.sf.saxon.s9api.QName;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.SaxonApiUncheckedException;
import net.sf.saxon.s9api.XdmValue;
import net.sf.saxon.s9api.XsltExecutable;
import net.sf.saxon.s9api.XsltTransformer;
import org.jimkast.ooj.bisource.BiSource;

public interface SaxonSource {
    void feed(Destination dest);


    final class Xsl implements SaxonSource {
        private final XsltExecutable xsl;
        private final BiSource<QName, XdmValue> params;

        public Xsl(XsltExecutable xsl) {
            this(xsl, BiSource.Empty.instance());
        }

        public Xsl(XsltExecutable xsl, BiSource<QName, XdmValue> params) {
            this.xsl = xsl;
            this.params = params;
        }

        @Override
        public void feed(Destination dest) {
            XsltTransformer t = xsl.load();
            params.feed(t::setParameter);
            t.setDestination(dest);
            try {
                t.transform();
            } catch (SaxonApiException e) {
                throw new SaxonApiUncheckedException(e);
            }
        }
    }
}
