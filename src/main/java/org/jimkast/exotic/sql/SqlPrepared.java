package org.jimkast.exotic.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.number.types.array;
import org.jimkast.exotic.possible.possible;

public interface SqlPrepared {
    possible<Row> rows(array<binary> params) throws SQLException;

    final class Jdbc implements SqlPrepared {
        private final PreparedStatement st;

        public Jdbc(PreparedStatement st) {
            this.st = st;
        }

        @Override
        public possible<Row> rows(array<binary> params) throws SQLException {
            int len = params.length();
            for (int i = 0; i < len; i++) {

            }
            return new RsAsPossible(st.executeQuery());
        }
    }
}
