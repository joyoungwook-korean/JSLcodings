package com.company.jsl_07.JDBCProject.CRUDexam;

import com.company.jsl_07.JDBCProject.util.MysqlManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDept {
    public static void main(String[] args) {
        Connection connection = MysqlManager.getConnection();
        Statement statement = null;
        ResultSet rs = null;
        try{
           statement = connection.createStatement();
           rs = statement.executeQuery("select * from dept");
            while (rs.next()){
                int dno = rs.getInt("dno");
                String dname = rs.getString(2);
                String loc = rs.getString(3);

                System.out.println(dno +"\t "+ dname +"\t "+ loc);
            }
            rs.close();
            statement.close();
        }catch (Exception e){

        }
    }
}
