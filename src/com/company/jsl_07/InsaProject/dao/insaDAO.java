package com.company.jsl_07.InsaProject.dao;



import com.company.jsl_07.InsaProject.model.insaVO;
import com.company.jsl_07.InsaProject.util.MysqlManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class insaDAO {
    private static insaDAO instance = new insaDAO();

    public static insaDAO getInstance() {
        return instance;
    }

    public List<insaVO> insa_group_Select(){
        String sql = "select d.dcode, dname, inwon, count(p.dcode) as count" +
                "	from tbl_person_001 p, tbl_dept_001 d" +
                "		where p.dcode=d.dcode" +
                "			group by dcode" +
                "				order by count(p.dcode) desc;";
        PreparedStatement preparedStatement = MysqlManager.con(sql);
        ResultSet rs= null;
        List<insaVO> list = new ArrayList<>();
        try {
            rs = preparedStatement.executeQuery();
            while(rs.next()) {
                insaVO vo = new insaVO();
                vo.setDcode(rs.getString("dcode"));
                vo.setDname(rs.getString("dname"));
                vo.setInwon(rs.getInt("inwon"));
                vo.setDuty(rs.getString("count"));

                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<insaVO> insa_Select() {
        String sql = "select * from tbl_person_001";
        PreparedStatement preparedStatement = MysqlManager.con(sql);
        ResultSet rs = null;
        insaVO vo = null;
        List<insaVO> list = new ArrayList<>();
        try {
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                vo = new insaVO();
                vo.setSawon(rs.getInt("sawon"));
                vo.setName(rs.getString("name"));
                vo.setDuty(rs.getString("duty"));
                vo.setPhone(rs.getString("phone"));
                String indate = Check_date(rs.getString("indate"));
                vo.setIndate(indate);
                String outdate1 = Check_date(rs.getString("outdate"));
                vo.setOutdate(outdate1);
                vo.setDcode(rs.getString("dcode"));
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public void insa_Insert(insaVO vo) {
        String sql = "insert into tbl_person_001 values(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement =
                MysqlManager.con(sql);
        try {
            preparedStatement.setInt(1, vo.getSawon());
            preparedStatement.setString(2, vo.getName());
            preparedStatement.setString(3, vo.getDuty());
            preparedStatement.setString(4, vo.getPhone());
            if (vo.getIndate().isEmpty() || vo.getIndate().equals("") || vo.getIndate() == "") {
                preparedStatement.setString(5, getDate());
            } else {
                preparedStatement.setString(5, vo.getIndate());
            }
            preparedStatement.setString(6, vo.getOutdate());
            preparedStatement.setString(7, vo.getDcode());
            int row = preparedStatement.executeUpdate();

        } catch (Exception e) {

        }
    }

    public insaVO insa_getChk(int sawon){
        String sql = "select * from tbl_person_001 where sawon=?";
        PreparedStatement preparedStatement = MysqlManager.con(sql);
        ResultSet rs = null;
        insaVO vo =null;
        try {
            preparedStatement.setInt(1,sawon);
            rs = preparedStatement.executeQuery();
            rs.next();
                vo = new insaVO();
                vo.setSawon(rs.getInt("sawon"));
                vo.setName(rs.getString("name"));
                vo.setDuty(rs.getString("duty"));
                vo.setPhone(rs.getString("phone"));
                vo.setIndate(rs.getString("indate"));
                if(rs.getString("outdate")==null){
                    vo.setOutdate("");
                }else{
                    vo.setOutdate(rs.getString("outdate"));
                }
                vo.setDcode(rs.getString("dcode"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }

    public static int insa_Max() {
        String sql = "select max(sawon) from tbl_person_001";
        PreparedStatement preparedStatement =
                MysqlManager.con(sql);
        int max = 1001;
        try {
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            if (rs.getInt(1) != 0) {
                max = rs.getInt(1);
                max++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return max;
    }

    public static String getDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String today = sdf.format(date);
        return today;
    }

    public static String Check_date(String date){
        if(date==null) return "\t\t";
        else{
            if(date.length()==8){
                String year = date.substring(0,4);
                String month = date.substring(4,6);
                String day = date.substring(6,8);
                return year+"-"+month+"-"+day;
            }else {
                String year = date.substring(0,4);
                String month = date.substring(5,7);
                String day = date.substring(9,11);
                return year+month+day;
            }
        }

    }
}
