package org.jimkast.exotic.sql;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.text.of_charseq;

public final class RsRow implements Row {
    private final ResultSet rs;

    public RsRow(ResultSet rs) {
        this.rs = rs;
    }

    @Override
    public int single(int i) throws SQLException {
        return rs.getInt(i);
    }

    @Override
    public binary binary(int i) throws SQLException {
        return new of_charseq(rs.getString(i));
    }

    @Override
    public InputStream stream(int i) throws SQLException {
        return rs.getBinaryStream(i);
    }

    @Override
    public int length() throws SQLException {
        return rs.getMetaData().getColumnCount();
    }
}
