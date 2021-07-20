package com.company.jsl_07.ShopProject.model;

import com.company.jsl_07.ShopProject.util.MysqlManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ShopSQL {
    Connection connection = MysqlManager.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet=null;
    public void insert_Member(int custno, String custname, String phone, String gender, String joindate, String grade, String city) {
        try {
            preparedStatement = connection.prepareStatement("insert into tbl_member_001 values (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, custno);
            preparedStatement.setString(2, custname);
            preparedStatement.setString(3, phone);
            if(gender.equals('m')) gender="M";
            if(gender.equals('f')) gender="F";
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, joindate);
            preparedStatement.setString(6, grade);
            preparedStatement.setString(7, city);
            int row = preparedStatement.executeUpdate();
            System.out.println(row);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert_Money(int custno, int saleno, int pcost, int amount, int price, String pcode, String sdate) {
        try {
            preparedStatement = connection.prepareStatement("insert into tbl_money_001 values (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, custno);
            preparedStatement.setInt(2, saleno);
            preparedStatement.setInt(3, pcost);
            preparedStatement.setInt(4, amount);
            preparedStatement.setInt(5, price);
            preparedStatement.setString(6, pcode);
            preparedStatement.setString(7, sdate);
            int row = preparedStatement.executeUpdate();
            System.out.println(row);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void insert_City(String city, String cityname){
        try {
            preparedStatement = connection.prepareStatement("insert into tbl_city_001 values (?,?)");
            preparedStatement.setString(1, city);
            preparedStatement.setString(2, cityname);
            int row = preparedStatement.executeUpdate();
            System.out.println(row);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSelect(String table){
        try {
            String s = table;
            preparedStatement = connection.prepareStatement("select * from ?");
            preparedStatement.setString(1,s);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                for(int i=1; i<resultSet.getMetaData().getColumnCount(); i++){
                    System.out.print(resultSet.getObject(i));
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
