package com.company.jsl_07.ShopProject.model.dao;

import com.company.jsl_07.ShopProject.model.insa.insaVO;
import com.company.jsl_07.ShopProject.util.MysqlManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class insaDAO {
    private static insaDAO instance = new insaDAO();

    public static insaDAO getInstance() {
        return instance;
    }


    public void insa_Insert(insaVO vo) {
        String sql = "insert into tbl_person_001 values(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement =
                MysqlManager.con(sql);
        try {
            preparedStatement.setInt(1,vo.getSawon());
            preparedStatement.setString(2,vo.getName());
            preparedStatement.setString(3,vo.getDuty());
            preparedStatement.setString(4,vo.getPhone());
            if(vo.getIndate()==null || vo.getIndate().equals("0")){
                preparedStatement.setString(5, getDate());
            }else{
                preparedStatement.setString(5,vo.getIndate());
            }
            preparedStatement.setString(6,vo.getOutdate());
            preparedStatement.setString(7,vo.getDcode());
            int row = preparedStatement.executeUpdate();

        } catch (Exception e) {

        }
    }

    public static int insa_Max() {
        String sql = "select max(sawon) from tbl_person_001";
        PreparedStatement preparedStatement =
                MysqlManager.con(sql);
        int max = 1001;
        try {
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            if(rs.getInt(1)!=0){
                max = rs.getInt(1);
                max++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return max;
    }

    public static String getDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String today = sdf.format(date);
        return today;
    }
}
