package project_A_0805.DB_Connection.db.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OracleDBManager implements DBManager{

    public Connection getConnection() {
        Connection connection = null;
        String myDriver= "oracle.jdbc.driver.OracleDriver";
        String myUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String myId = "hr";
        String myPassword = "1234";
        try {
            Class.forName(myDriver);
            connection = DriverManager.getConnection(myUrl, myId, myPassword);
        } catch (Exception var6) {
            var6.printStackTrace();
        }
        return connection;
    }

    @Override
    public Connection getConnection(String db, String id, String pw) {
        Connection connection = null;
        String myDriver= "oracle.jdbc.driver.OracleDriver";
        String myUrl = "jdbc:oracle:thin:@localhost:1521:"+db;
        try {
            Class.forName(myDriver);
            connection = DriverManager.getConnection(myUrl, id, pw);
        } catch (Exception var6) {
            var6.printStackTrace();
        }
        return connection;
    }

    public Connection getConnection(String id, String pw) {
        Connection connection = null;
        String myDriver= "oracle.jdbc.driver.OracleDriver";
        String myUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            Class.forName(myDriver);
            connection = DriverManager.getConnection(myUrl, id, pw);
        } catch (Exception var6) {
            var6.printStackTrace();
        }
        return connection;
    }
}
