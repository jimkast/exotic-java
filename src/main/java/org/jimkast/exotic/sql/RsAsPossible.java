package org.jimkast.exotic.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Consumer;
import org.jimkast.exotic.possible.possible;

public final class RsAsPossible implements possible<Row> {
    private final ResultSet rs;

    public RsAsPossible(ResultSet rs) {
        this.rs = rs;
    }

    @Override
    public void supply(Consumer<? super Row> consumer) {
        try {
            if (rs.next()) {
                consumer.accept(new RsRow(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
