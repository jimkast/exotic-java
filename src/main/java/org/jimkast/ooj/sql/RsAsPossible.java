package org.jimkast.ooj.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.jimkast.ooj.source.Source;
import org.jimkast.ooj.source.Target;

public final class RsAsPossible implements Source<Row> {
    private final ResultSet rs;

    public RsAsPossible(ResultSet rs) {
        this.rs = rs;
    }

    @Override
    public void feed(Target<Row> target) {
        try {
            if (rs.next()) {
                target.accept(new RsRow(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
