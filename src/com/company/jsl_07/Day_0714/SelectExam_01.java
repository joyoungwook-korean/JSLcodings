package com.company.jsl_07.Day_0714;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectExam_01 {
    public static void main(String[] args) {
        Connection connection = null;
        //db연결
        Statement stmt = null;
        //sql 명령어
        ResultSet rs = null;
        // 값을 저장

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/track2_4","track2_4","1234");
            System.out.println(connection + "객체 생성");
        }catch (Exception e){
            e.printStackTrace();
        }
        String sql = "select * from dept";
        try{

            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                System.out.print(rs.getInt("dno"));
                System.out.print(rs.getString("dname"));
                System.out.print(rs.getString("loc"));
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
