package org.jimkast.exotic.sql;

import java.sql.SQLException;
import org.jimkast.exotic.possible.possible;

public interface SqlExchange {
    possible<Row> rs() throws SQLException;
}
