package org.jimkast.ooj.sql;

import java.sql.SQLException;
import org.jimkast.ooj.source.Source;

public interface SqlExchange {
    Source<Row> rs() throws SQLException;
}
