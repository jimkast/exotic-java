package org.jimkast.ooj.sql;

import java.sql.SQLException;
import org.jimkast.ooj.lang.Array;
import org.jimkast.ooj.lang.Binary;
import org.jimkast.ooj.source.Source;
import org.jimkast.ooj.target.ObjectArray;

public final class Prepared implements SqlExchange {
    private final SqlPrepared st;
    private final Array<Binary> params;

    public Prepared(SqlPrepared st, Binary... params) {
        this(st, new ObjectArray.Native<>(params));
    }

    public Prepared(SqlPrepared st, Array<Binary> params) {
        this.st = st;
        this.params = params;
    }

    @Override
    public Source<Row> rs() throws SQLException {
        return st.rows(params);
    }
}
