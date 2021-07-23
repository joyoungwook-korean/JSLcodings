package com.company.bookProject.comjslhrd.model.DAO;

import com.company.bookProject.comjslhrd.model.VO.BookVo;
import com.company.bookProject.comjslhrd.util.SqlManager;
import com.company.jsl_07.ShopProject.util.MysqlManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookDAO {
    private static BookDAO instance = new BookDAO();
    public static BookDAO getInstance(){ return instance;}

    public void book_Insert(BookVo vo){
        String sql = "insert into tbl_member_002 values (?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = SqlManager.con(sql);
        try {
            pstmt.setInt(1, vo.getUserno());
            pstmt.setString(2, vo.getName());
            String chec[] = check_phone_Num(vo.getPhone_all());
            int i=3;
            for(String s : chec){
                pstmt.setString(i,s);
                i++;
            }
            pstmt.setString(6, vo.getGender());
            pstmt.setString(7, vo.getBirthday());
            pstmt.setString(8, vo.getRegdate());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MysqlManager.close(pstmt);
        }
    }

    public BookVo find_Select(int userno){
        String sql = "select * from tbl_member_002 where userno=?";
        PreparedStatement preparedStatement = SqlManager.con(sql);
        ResultSet rs = null;
        BookVo vo = null;
        try{
            preparedStatement.setInt(1,userno);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
                vo = new BookVo();
                vo.setName(rs.getString("name"));
                String gender = "남자";
                vo.setBirthday(rs.getString("birthday"));
                if(rs.getString("gender").equals("F")) gender="여자";
                vo.setGender(gender);
                String phone_all = rs.getString("phone1")+ "-" +rs.getString("phone2") + "-" + rs.getString("phone3");
                vo.setPhone_all(phone_all);
                vo.setRegdate(rs.getString("regdate"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            SqlManager.close(preparedStatement,rs);
        }
        return vo;
    }

    public List<BookVo> select_All_Member(){
        String sql = "select * from tbl_member_002";
        PreparedStatement preparedStatement = SqlManager.con(sql);
        ResultSet rs = null;
        BookVo vo = null;
        List<BookVo> list = new ArrayList<>();
        try{
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                vo = new BookVo();
                vo.setUserno(rs.getInt("userno"));
                vo.setName(rs.getString("name"));
                String gender = "남자";
                vo.setBirthday(rs.getString("birthday"));
                if(rs.getString("gender").equals("F")) gender="여자";
                vo.setGender(gender);
                String phone_all = rs.getString("phone1")+ "-" +rs.getString("phone2") + "-" + rs.getString("phone3");
                vo.setPhone_all(phone_all);
                vo.setRegdate(day_Change(rs.getString("regdate")));

                list.add(vo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            SqlManager.close(preparedStatement,rs);
        }
        return list;
    }

    public List<BookVo> select_All_Booklent(){

        String sql ="select b.lentno, b.userno, name, c.bookname, b.outdate, b.indate " +
                "from tbl_member_002 m, tbl_booklent_002 b, tbl_bookcode_002 c "+
                "where b.userno=m.userno and b.bookno=c.bookno "+
                "group by lentno "+
                "order by userno asc,lentno desc";
        PreparedStatement preparedStatement = SqlManager.con(sql);
        ResultSet rs = null;
        BookVo vo = null;
        List<BookVo> list = new ArrayList<>();
        try{
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                vo = new BookVo();
                vo.setLentno(rs.getInt("lentno"));
                vo.setUserno(rs.getInt("userno"));
                vo.setName(rs.getString("name"));
                vo.setBookname(rs.getString("bookname"));
                vo.setOutdate(rs.getString("outdate"));
                String s = rs.getString("indate");
                String temp = day_Change(s);
                vo.setIndate(temp);
                list.add(vo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            SqlManager.close(preparedStatement,rs);
        }
        return list;
    }

    public List<BookVo> select_All_Booknow(){

        String sql ="select c.bookno, bookname, regdate, count(outdate) as countout, count(indate) as countin " +
                "from tbl_bookcode_002 c, tbl_booklent_002 b "+
                "where b.bookno=c.bookno "+
                "group by bookno " +
                "order by countout desc, countin desc";
        PreparedStatement preparedStatement = SqlManager.con(sql);
        ResultSet rs = null;
        BookVo vo = null;
        List<BookVo> list = new ArrayList<>();
        try{
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                vo = new BookVo();
                vo.setBookno(rs.getInt("bookno"));
                vo.setBookname(rs.getString("bookname"));
                vo.setCode_regdate(rs.getString("regdate"));
                vo.setUserno(rs.getInt("countout"));
                vo.setLentno(rs.getInt("countin"));
                list.add(vo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            SqlManager.close(preparedStatement,rs);
        }
        return list;
    }


    static String[] check_phone_Num(String phone){
        String[] temp = new String[3];
        if(phone.length()>11){
            temp= phone.split("-");

        }else{
            temp[0]=phone.substring(0,3);
            temp[1] = phone.substring(3,7);
            temp[2] = phone.substring(7,11);
        }
        return temp;
    }

    static String day_Change(String day){
        if(day==null){
            return "";
        }else{
            String temp[] = new String[3];
            temp[0] = day.substring(0,4);
            temp[1] = day.substring(4,6);
            temp[2] = day.substring(6,8);

            return temp[0] + "년" + temp[1] + "월" + temp[2] +"일";
        }


    }

    public static String getDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String today = sdf.format(date);
        return today;
    }

    public int book_Max() {
        String sql = "select max(userno) from tbl_member_002";
        PreparedStatement preparedStatement =
                SqlManager.con(sql);
        int max = 100001;
        ResultSet rs = null;
        try {
             rs= preparedStatement.executeQuery();
            rs.next();
            if(rs.getInt(1)!=0){
                max = rs.getInt(1);
                max++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return max;
    }

}
