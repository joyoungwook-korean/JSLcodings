package com.company.jsl_07.JDBCProject.CRUDexam;

import com.company.jsl_07.JDBCProject.util.MysqlManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectEmp_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        Connection connection  = MysqlManager.getConnection();
        Statement statement = null;
        ResultSet rs = null;
        try{
            statement = connection.createStatement();
            rs = statement.executeQuery("select eno,ename,hiredate,salary,dno from emp where dno="+n);
            while (rs.next()){
                for(int i=1; i<=rs.getMetaData().getColumnCount(); i++){
                    System.out.print(rs.getObject(i) + " ");
                }
                System.out.println();
            }
            rs.close();
            statement.close();
        }catch (Exception e){

        }
    }
}
