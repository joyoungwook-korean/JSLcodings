package com.company.jsl_09.jsl_210903.util;


import java.sql.Connection;
import java.sql.DriverManager;

public class OracleDBManager implements DBManager {

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
