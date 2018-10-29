package org.jimkast.ooj.sql;

import java.sql.SQLException;
import org.jimkast.ooj.source.PSource;

public interface SqlExchange {
    PSource<Row> rs() throws SQLException;
}
