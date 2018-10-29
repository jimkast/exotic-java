package org.jimkast.ooj.sql;

import java.sql.SQLException;
import javax.sql.DataSource;

public interface Ds {
    Conn connect() throws SQLException;


    final class Jdbc implements Ds {
        private final DataSource ds;

        public Jdbc(DataSource ds) {
            this.ds = ds;
        }

        @Override
        public Conn connect() throws SQLException {
            return new Conn.Jdbc(ds.getConnection());
        }
    }
}
