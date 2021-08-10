//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package smartProject.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SmartMysqlManager {
    private static Connection conn = getConnection();
    public static Connection getConnection() {
        Connection connection = null;
      //  String myDriver = "com.mysql.jdbc.DriverManager";
        String myUrl = "jdbc:mysql://localhost:3306/track2_4";
        String myId = "track2_4";
        String myPassword = "1234";

        try {
         //   Class.forName(myDriver);
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
