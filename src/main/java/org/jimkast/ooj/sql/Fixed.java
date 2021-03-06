package org.jimkast.ooj.sql;

import java.sql.Connection;
import java.sql.SQLException;
import org.jimkast.ooj.source.Source;

public final class Fixed implements SqlExchange {
    private final Connection conn;
    private final CharSequence query;

    public Fixed(Connection conn, CharSequence query) {
        this.conn = conn;
        this.query = query;
    }

    @Override
    public Source<Row> rs() throws SQLException {
        return new RsAsPossible(conn.createStatement().executeQuery(query.toString()));
    }
}
