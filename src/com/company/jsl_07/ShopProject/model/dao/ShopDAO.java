package com.company.jsl_07.ShopProject.model.dao;

import com.company.jsl_07.ShopProject.model.CommVO;
import com.company.jsl_07.ShopProject.model.MemberVO;
import com.company.jsl_07.ShopProject.model.MoneyVO;
import com.company.jsl_07.ShopProject.util.MysqlManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopDAO {
    private ShopDAO() {
    }

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    private static ShopDAO instance = new ShopDAO();

    public static ShopDAO getInstance() {
        return instance;
    }

    public String getDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String today = sdf.format(date);
        return today;
    }

    public int moneyInsert(MoneyVO vo) {
        String sql = "insert into tbl_money_001  values (?,?,?,?,?,?,?)";
        PreparedStatement pstmt = MysqlManager.con(sql);
        int row = 0;
        try {
            pstmt.setInt(1, vo.getCustno());
            pstmt.setInt(2, vo.getSaleno());
            pstmt.setInt(3, vo.getPcost());
            pstmt.setInt(4, vo.getAmount());
            pstmt.setInt(5, vo.getPrice());
            pstmt.setString(6, vo.getPcode());
            pstmt.setString(7, vo.getSdate());
            row = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MysqlManager.close(pstmt);
        }
        return row;
    }

    public int memberInsert(MemberVO vo) {
        String sql = "insert into tbl_member_001  values (?,?,?,?,?,?,?)";
        PreparedStatement pstmt = MysqlManager.con(sql);
        int row = 0;
        try {
            pstmt.setInt(1, vo.getCustno());
            pstmt.setString(2, vo.getCustname());
            pstmt.setString(3, vo.getPhone());
            pstmt.setString(4, vo.getGender());
            pstmt.setString(5, vo.getJoindate());
            pstmt.setString(6, vo.getGrade());
            pstmt.setString(7, vo.getCity());
            row = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MysqlManager.close(pstmt);
        }
        return row;
    }

    public int custnoMax() {
        PreparedStatement pstmt = MysqlManager.con("select max(custno) from tbl_member_001");
        ResultSet rs = null;
        int max = 0;
        try {
            rs = pstmt.executeQuery();
            if (rs.next()) {
                max = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MysqlManager.close(pstmt, rs);
        }
        if (max == 0) max = 100001;
        else max++;
        return max;
    }

    public MemberVO member_CustNo_Check(int custNo) {
        String sql = "select * from tbl_member_001 where custno=?";
        PreparedStatement preparedStatement = MysqlManager.con(sql);
        ResultSet rs = null;
        MemberVO vo = null;
        try {
            preparedStatement.setInt(1, custNo);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                vo = new MemberVO();
                vo.setCustno(rs.getInt("custno"));
                vo.setCustname(rs.getString("custname"));
                if (rs.getString("gender").equals("M")) {
                    vo.setGender("남자");
                } else vo.setGender("여자");
                String date = rs.getString("joindate");
                String year = date.substring(0, 4);
                String month = date.substring(4, 6);
                String day = date.substring(6, 8);
                date = year + "-" + month + "-" + day;
                vo.setJoindate(date);
                vo.setCity(rs.getString("city"));
                if (rs.getString("grade").equals("A")) vo.setGrade("VIP");
                else if (rs.getString("grade").equals("B")) vo.setGrade("일반");
                else vo.setGrade("직원");
                vo.setPhone(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }

    public MoneyVO money_Check(int saleNo) {
        String sql = "select * from tbl_money_001 where saleno=?";
        PreparedStatement preparedStatement = MysqlManager.con(sql);
        ResultSet rs = null;
        MoneyVO vo = null;
        try {
            preparedStatement.setInt(1, saleNo);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                vo = new MoneyVO();
                vo.setPcode(rs.getString("pcode"));
                vo.setAmount(rs.getInt("amount"));
                vo.setPcost(rs.getInt("pcost"));
                vo.setPrice(rs.getInt("price"));
                vo.setCustno(rs.getInt("custno"));
                vo.setSaleno(rs.getInt("saleno"));
                String date = rs.getString("sdate");
                String year = date.substring(0, 4);
                String month = date.substring(4, 6);
                String day = date.substring(6, 8);
                date = year + "년" + month + "월" + day + "일";
                vo.setSdate(date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }

    public int money_CustNo_Check(int custNo) {
        String sql = "select custno from tbl_member_001 where custno=?";
        PreparedStatement preparedStatement = MysqlManager.con(sql);
        ResultSet rs = null;
        int cu = 0;
        try {
            preparedStatement.setInt(1, custNo);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                cu = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (cu == custNo) return cu;
        else {
            System.out.println("없는 회원 입니다.");
            return 0;
        }
    }

    public List<MemberVO> memberList() {
        String sql = "select * from tbl_member_001";
        PreparedStatement preparedStatement = MysqlManager.con(sql);
        List<MemberVO> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                MemberVO vo = new MemberVO();
                vo.setCustno(rs.getInt("custno"));
                vo.setCustname(rs.getString("custname"));
                if (rs.getString("gender").equals("M")) {
                    vo.setGender("남자");
                } else vo.setGender("여자");
                String date = rs.getString("joindate");
                String year = date.substring(0, 4);
                String month = date.substring(4, 6);
                String day = date.substring(6, 8);
                date = year + "년" + month + "월" + day + "일";
                vo.setJoindate(date);
                vo.setCity(rs.getString("city"));
                if (rs.getString("grade").equals("A")) vo.setGrade("VIP");
                else if (rs.getString("grade").equals("B")) vo.setGrade("일반");
                else vo.setGrade("직원");
                vo.setPhone(rs.getString("phone"));
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MysqlManager.close(preparedStatement, rs);
        }

        return list;

    }

    public List<MoneyVO> moneyList() {
        String sql = "select * from tbl_money_001";
        PreparedStatement preparedStatement = MysqlManager.con(sql);
        List<MoneyVO> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                MoneyVO vo = new MoneyVO();
                vo.setPcode(rs.getString("pcode"));
                vo.setAmount(rs.getInt("amount"));
                vo.setPcost(rs.getInt("pcost"));
                vo.setPrice(rs.getInt("price"));
                vo.setCustno(rs.getInt("custno"));
                vo.setSaleno(rs.getInt("saleno"));
                String date = rs.getString("sdate");
                String year = date.substring(0, 4);
                String month = date.substring(4, 6);
                String day = date.substring(6, 8);
                date = year + "년" + month + "월" + day + "일";
                vo.setSdate(date);

                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MysqlManager.close(preparedStatement, rs);
        }

        return list;

    }


    public List<CommVO> joinSelect_01() {
        List<CommVO> list = new ArrayList<>();
        PreparedStatement preparedStatement = MysqlManager.con("select custno,custname,phone,gender,joindate,grade,cityname\n" +
                "from tbl_member_001 m , tbl_city_001 c\n" +
                "where m.city=c.city;");

        ResultSet rs = null;
        try {
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                CommVO vo = new CommVO();
                vo.setCustno(rs.getInt("custno"));
                vo.setCustname(rs.getString("custname"));
                vo.setPhone(rs.getString("phone"));
                vo.setCityName(rs.getString("cityname"));
                if (rs.getString("gender").equals("M")) {
                    vo.setGender("남자");
                } else vo.setGender("여자");
                String date = rs.getString("joindate");
                String year = date.substring(0, 4);
                String month = date.substring(4, 6);
                String day = date.substring(6, 8);
                date = year + "년" + month + "월" + day + "일";
                vo.setJoindate(date);
                if (rs.getString("grade").equals("A")) vo.setGrade("VIP");
                else if (rs.getString("grade").equals("B")) vo.setGrade("일반");
                else vo.setGrade("직원");
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MysqlManager.close(preparedStatement, rs);
        }
        return list;
    }
    public List<CommVO> group_01() {
        List<CommVO> list = new ArrayList<>();
        String sql="select M1.custno,custname,phone,grade,sum(price) as sum\n" +
                "from tbl_member_001 M1, tbl_money_001 M2\n" +
                "where M1.custno = M2.custno\n" +
                "group by M1.custno,custname,phone\n" +
                "order by sum(price) desc";
        PreparedStatement preparedStatement = MysqlManager.con(sql);
        ResultSet rs = null;
        try {
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                CommVO vo = new CommVO();
                vo.setCustno(rs.getInt("custno"));
                vo.setCustname(rs.getString("custname"));
                vo.setPhone(rs.getString("phone"));
                vo.setSum(rs.getInt("sum"));
                if (rs.getString("grade").equals("A")) vo.setGrade("VIP");
                else if (rs.getString("grade").equals("B")) vo.setGrade("일반");
                else vo.setGrade("직원");
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MysqlManager.close(preparedStatement, rs);
        }
        return list;
    }

}
