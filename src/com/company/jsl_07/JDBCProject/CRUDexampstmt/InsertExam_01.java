package com.company.jsl_07.JDBCProject.CRUDexampstmt;

import com.company.jsl_07.JDBCProject.util.MysqlManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InsertExam_01 {
    public static void main(String[] args) {
        int dno=90;
        String dname= "경영";
        String loc = "제주";
        Connection conn = MysqlManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String sql = "insert into dept values (?,?,?)";
        try{
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,dno);
            preparedStatement.setString(2,"aaaa");
            preparedStatement.setString(3,"bbbbb");
            int row = preparedStatement.executeUpdate();
            System.out.println(row);
        }catch (Exception e){

        }
    }
}
