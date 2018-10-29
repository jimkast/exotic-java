package org.jimkast.ooj.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.source.PSource;
import org.jimkast.ooj.source.Target;

public final class RsAsPossible implements PSource<Row> {
    private final ResultSet rs;

    public RsAsPossible(ResultSet rs) {
        this.rs = rs;
    }

    @Override
    public Cond feed(Target<Row> target) {
        try {
            if (rs.next()) {
                target.accept(new RsRow(rs));
                return Cond.TRUE;
            }
            return Cond.FALSE;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
