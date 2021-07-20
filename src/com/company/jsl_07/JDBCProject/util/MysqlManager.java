package com.company.jsl_07.JDBCProject.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MysqlManager {
    Connection conn = getConnection();
    PreparedStatement preparedStatement =null;
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

    public int select_Track2_4(int dno){
        return 1;
    }


}
