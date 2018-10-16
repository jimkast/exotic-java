package org.jimkast.exotic.sql;

import java.sql.SQLException;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.number.types.array;
import org.jimkast.exotic.possible.possible;

public final class Prepared implements SqlExchange {
    private final SqlPrepared st;
    private final array<binary> params;

    public Prepared(SqlPrepared st, binary... params) {
        this(st, new array.jdk<>(params));
    }

    public Prepared(SqlPrepared st, array<binary> params) {
        this.st = st;
        this.params = params;
    }

    @Override
    public possible<Row> rs() throws SQLException {
        return st.rows(params);
    }
}
