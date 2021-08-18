package com.company.jsl_08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OracleDBManager {
    private static Connection conn = getConnection();

    public static Connection getConnection() {
        Connection connection = null;
        String myDriver = "oracle.jdbc.driver.OracleDriver";
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

    public static PreparedStatement con(String sql) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
        } catch (Exception var3) {
            var3.printStackTrace();
        }
        return pstmt;
    }

    public static ResultSet con_rs(String sql) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return rs;
    }
    public static void close(PreparedStatement pstmt) {
        try {
            pstmt.close();
            conn.close();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public static void close(PreparedStatement pstmt, ResultSet rs) {
        try {
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }



}
