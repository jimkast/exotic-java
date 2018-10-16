package org.jimkast.exotic.sql;

import java.sql.Connection;
import java.sql.SQLException;
import org.jimkast.exotic.possible.possible;

public final class Fixed implements SqlExchange {
    private final Connection conn;
    private final CharSequence query;

    public Fixed(Connection conn, CharSequence query) {
        this.conn = conn;
        this.query = query;
    }

    @Override
    public possible<Row> rs() throws SQLException {
        return new RsAsPossible(conn.createStatement().executeQuery(query.toString()));
    }
}
