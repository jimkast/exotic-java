package org.jimkast.ooj.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.jimkast.ooj.lang.Array;
import org.jimkast.ooj.lang.Binary;
import org.jimkast.ooj.source.PSource;

public interface SqlPrepared {
    PSource<Row> rows(Array<Binary> params) throws SQLException;

    final class Jdbc implements SqlPrepared {
        private final PreparedStatement st;

        public Jdbc(PreparedStatement st) {
            this.st = st;
        }

        @Override
        public PSource<Row> rows(Array<Binary> params) throws SQLException {
            int len = params.length();
            for (int i = 0; i < len; i++) {

            }
            return new RsAsPossible(st.executeQuery());
        }
    }
}
