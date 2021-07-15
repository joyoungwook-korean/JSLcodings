package com.company.jsl_07.Day_0714.jdbcexam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyDao extends MySQLConn{
    Statement statement = null;
    ResultSet rs = null;
    public void deptList(){
        String sql = "select * from dept";
        try{
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
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
    @Override
    public void cleanup() {
        try{
            rs.close();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
