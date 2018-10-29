package org.jimkast.ooj.sql;

import java.io.InputStream;
import java.sql.SQLException;
import org.jimkast.exotic.binary.binary;

public interface Row {
    int single(int i) throws SQLException;

    binary binary(int i) throws SQLException;

    InputStream stream(int i) throws SQLException;

    int length() throws SQLException;
}
