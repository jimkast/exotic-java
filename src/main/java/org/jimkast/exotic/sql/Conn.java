package org.jimkast.exotic.sql;

import java.sql.Connection;

public interface Conn {
    Connection jdbc();


    final class Jdbc implements Conn {
        private final Connection conn;

        public Jdbc(Connection conn) {
            this.conn = conn;
        }

        @Override
        public Connection jdbc() {
            return conn;
        }
    }
}
