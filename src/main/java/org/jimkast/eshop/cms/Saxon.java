package org.jimkast.eshop.cms;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.Writer;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import net.sf.saxon.s9api.DocumentBuilder;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.SaxonApiUncheckedException;
import net.sf.saxon.s9api.XPathCompiler;
import net.sf.saxon.s9api.XQueryCompiler;
import net.sf.saxon.s9api.XdmItem;
import net.sf.saxon.s9api.XdmValue;
import net.sf.saxon.s9api.XsltCompiler;
import net.sf.saxon.s9api.XsltExecutable;
import net.sf.saxon.s9api.XsltTransformer;
import net.sf.saxon.tree.tiny.CharSlice;
import net.sf.saxon.tree.util.FastStringBuffer;
import org.cactoos.iterable.Mapped;
import org.jimkast.ooj.net.CharSource;

public final class Saxon {
    public static final Processor PROCESSOR = new Processor(false);
    public static final XQueryCompiler XQ_COMPILER = PROCESSOR.newXQueryCompiler();
    public static final DocumentBuilder DOC_BUILDER = PROCESSOR.newDocumentBuilder();
    public static final XsltCompiler XSLT_COMPILER = PROCESSOR.newXsltCompiler();
    public static final XPathCompiler XPATH_COMPILER = PROCESSOR.newXPathCompiler();
    public static final Xsl XSL_IDENTITY;

    static {
        try {
            XSL_IDENTITY = new SXsl(XSLT_COMPILER.compile(new StreamSource(new StringReader(
                "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\n" +
                    "  <xsl:strip-space elements=\"*\"/>\n" +
                    "  <xsl:template match=\"@*|node()\">\n" +
                    "    <xsl:copy>\n" +
                    "      <xsl:apply-templates select=\"@*|node()\"/>\n" +
                    "    </xsl:copy>\n" +
                    "  </xsl:template>\n" +
                    "</xsl:stylesheet>"
            ))));
        } catch (SaxonApiException e) {
            throw new SaxonApiUncheckedException(e);
        }
    }

    public Xsl compile(String url) {
        return compile(new StreamSource(url));
    }

    public Xsl compile(Source source) {
        try {
            return new SXsl(XSLT_COMPILER.compile(source));
        } catch (SaxonApiException e) {
            throw new SaxonApiUncheckedException(e);
        }
    }

    public static final class SXsl implements Xsl {
        private final Processor proc;
        private final XsltExecutable xsl;

        public SXsl(XsltExecutable xsl) {
            this(PROCESSOR, xsl);
        }

        public SXsl(Processor proc, XsltExecutable xsl) {
            this.proc = proc;
            this.xsl = xsl;
        }

        @Override
        public void accept(Source source, OutputStream out) {
            try {
                XsltTransformer t = xsl.load();
                t.setSource(source);
                t.setDestination(proc.newSerializer(out));
                t.transform();
            } catch (SaxonApiException e) {
                throw new SaxonApiUncheckedException(e);
            }
        }
    }


    public interface SaxonXdm {
        XdmValue xdm();
    }

    public interface SaxonXQuery {
        XdmValue query(SaxonXdm item);
    }

    public interface SaxonXpathCompiler {
        SaxonXQuery compile(String text);
    }

    public interface Markup extends CharSource {
        Iterable<Markup> query(String text);
    }


    public static final class MemXml implements Markup, SaxonXdm {
        private final XdmItem xdm;

        public MemXml(XdmItem xdm) {
            this.xdm = xdm;
        }

        @Override
        public XdmValue xdm() {
            return xdm;
        }


        @Override
        public Iterable<Markup> query(String text) {
            try {
                return new Mapped<>(
                    MemXml::new,
                    XPATH_COMPILER.evaluate(text, xdm)
                );
            } catch (SaxonApiException e) {
                throw new SaxonApiUncheckedException(e);
            }
        }

        @Override
        public void feed(Writer out) throws IOException {
            CharSequence cs = xdm.getUnderlyingValue().getStringValueCS();
            if (cs instanceof FastStringBuffer) {
                ((FastStringBuffer) cs).write(out);
            } else if (cs instanceof CharSlice) {
                ((CharSlice) cs).write(out);
            } else {
                int len = cs.length();
                for (int i = 0; i < len; i++) {
                    out.write(cs.charAt(i));
                }
            }
            throw new RuntimeException("Not a CharSource");
        }
    }

}
