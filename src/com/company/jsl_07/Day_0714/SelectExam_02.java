package com.company.jsl_07.Day_0714;

import java.sql.*;

public class SelectExam_02 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/track2_4","track2_4","1234");
        }catch (Exception e){
            e.printStackTrace();
        }
        EmpVO empVO = new EmpVO();
        String sql = "select * from emp";
        try{
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()){
                empVO.setEno(rs.getInt("eno"));
                empVO.setCommission(rs.getInt("commission"));
                empVO.setDno(rs.getInt("dno"));
                empVO.setEname(rs.getString("ename"));
                empVO.setManager(rs.getInt("manager"));
                empVO.setHiredate(rs.getString("hiredate"));
                empVO.setJob(rs.getString("job"));
                empVO.setSalary(rs.getInt("salary"));

               System.out.println(empVO.getEno()+ " "+
                empVO.getCommission()+ " "+
                empVO.getDno()+ " "+
                empVO.getEname()+ " "+
                empVO.getManager()+ " "+
                empVO.getHiredate()+ " "+
                empVO.getJob()+ " "+
                empVO.getSalary());

            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                rs.close();
                statement.close();
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }


        }
    }
}
