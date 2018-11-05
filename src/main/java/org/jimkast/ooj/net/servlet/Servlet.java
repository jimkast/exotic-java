package org.jimkast.ooj.net.servlet;

import java.io.IOException;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jimkast.ooj.map.Mapping;
import org.jimkast.ooj.map.iterable.Choose;

public interface Servlet {
    void accept(HttpServletRequest req, HttpServletResponse res) throws IOException;

    class Env implements Servlet {
        private final Servlet origin;

        public Env(Servlet origin) {
            this.origin = origin;
        }

        @Override
        public final void accept(HttpServletRequest req, HttpServletResponse res) throws IOException {
            origin.accept(req, res);
        }
    }

    final class All implements Servlet {
        private final Iterable<Servlet> all;

        public All(Iterable<Servlet> all) {
            this.all = all;
        }

        @Override
        public void accept(HttpServletRequest req, HttpServletResponse res) throws IOException {
            for (Servlet servlet : all) {
                servlet.accept(req, res);
            }
        }
    }

    final class Fork implements Servlet {
        private final Mapping<HttpServletRequest, Servlet> mapping;

        @SafeVarargs
        public Fork(Servlet def, Mapping<HttpServletRequest, Iterator<Servlet>>... mappings) {
            this(new Choose<>(def, mappings));
        }

        public Fork(Mapping<HttpServletRequest, Servlet> mapping) {
            this.mapping = mapping;
        }

        @Override
        public void accept(HttpServletRequest req, HttpServletResponse res) throws IOException {
            mapping.map(req).accept(req, res);
        }
    }
}
