package project_A_0805.DB_Connection.db.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface DBManager {
    Connection getConnection();
    Connection getConnection(String id, String pw);
    Connection getConnection(String db, String id, String pw);
}
