package com.company.jsl_07.JDBCProject.CRUDexam;

import com.company.jsl_07.JDBCProject.util.MysqlManager;

import java.sql.Connection;

public class DBTest {
    public static void main(String[] args) {
        Connection connection = MysqlManager.getConnection();
        System.out.println(connection);
    }
}
