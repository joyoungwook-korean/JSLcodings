package com.company.jsl_07.InsaProject.util;

import java.sql.*;

public class MysqlManager {
    private static Connection conn=getConnection();

    public static Connection getConnection(){
        Connection connection = null;
        String myDriver="com.mysql.jdbc.Driver";
        String myUrl="jdbc:mysql://localhost:3306/track2_4";
        String myId="track2_4";
        String myPassword="1234";
        try{
            Class.forName(myDriver);
            connection = DriverManager.getConnection(myUrl,myId,myPassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }


    public static PreparedStatement con( String sql){
        PreparedStatement pstmt=null;

        try{
            pstmt = conn.prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        return pstmt;
    }
    //연결 종료
    public static void close( PreparedStatement pstmt){
        try{
            pstmt.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void close( PreparedStatement pstmt, ResultSet rs){
        try{
            rs.close();
            pstmt.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
