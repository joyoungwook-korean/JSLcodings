package com.company.dateba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Optional;

public class MuSqlConnTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("로딩 성공");
        }catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/track2_4","track2_4","1234");
            System.out.println(connection + "켜짐");
            connection.close();
        }catch ( Exception e){
            e.printStackTrace();


        }
    }
}
