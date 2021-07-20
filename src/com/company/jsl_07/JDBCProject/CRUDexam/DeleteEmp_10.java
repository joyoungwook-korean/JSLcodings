package com.company.jsl_07.JDBCProject.CRUDexam;

import com.company.jsl_07.JDBCProject.util.MysqlManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteEmp_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("부서 번호 입력 :");
        String n = scanner.next();
        Connection connection  = MysqlManager.getConnection();
        Statement statement = null;
        Statement statement1 = null;
        ResultSet rs = null;
        try{
            statement1 = connection.createStatement();
            statement = connection.createStatement();
            statement1.executeQuery("INSERT INTO track2_4.emp (ENO, ENAME, JOB, MANAGER, HIREDATE, SALARY, COMMISSION, DNO) VALUES (9999, 'sa', 'df', 8888, null, null, null, 40");
            rs = statement.executeQuery("delete from emp where dno="+n);
            rs.next();
            System.out.println(rs.getObject(1));
            rs.close();
            statement.close();
        }catch (Exception e){

        }
    }
}
