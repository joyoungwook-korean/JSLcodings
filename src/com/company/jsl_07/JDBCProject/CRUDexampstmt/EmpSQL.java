package com.company.jsl_07.JDBCProject.CRUDexampstmt;

import com.company.jsl_07.JDBCProject.util.MysqlManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpSQL {
    Connection connection = MysqlManager.getConnection();

    PreparedStatement preparedStatement = null;
    ResultSet rs = null;


    public int insert_dept(int dno, String dname, String loc) {
        String insert = "insert into dept values(?,?,?)";
        int row = 0;
        try {
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, dno);
            preparedStatement.setString(2, dname);
            preparedStatement.setString(3, loc);
            row = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

 //검색
    public ResultSet select_All() {
        String select = "select * from emp";
        try {
            preparedStatement = connection.prepareStatement(select);
            rs = preparedStatement.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }


}

