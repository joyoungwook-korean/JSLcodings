package com.company.jsl_07.JDBCProject.CRUDexampstmt;

import com.company.jsl_07.JDBCProject.util.MysqlManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectExam_01 {
    public static void main(String[] args) {
        int dno=10;
        Connection conn = MysqlManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String sql = "select * from emp where dno=?";
        try{
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,dno);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                for(int i=1; i<=rs.getMetaData().getColumnCount(); i++){
                    System.out.print(rs.getObject(i) + " ");
                }
                System.out.println();
            }
        }catch (Exception e){

        }
    }
}
