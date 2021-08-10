//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package smartProject.model;

import java.security.spec.ECField;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import smartProject.util.SmartMysqlManager;

public class SmartDAO {
    private static SmartDAO instance = new SmartDAO();

    private SmartDAO() {
    }

    public static SmartDAO getInstance() {
        return instance;
    }

    //insert
    public void insert_Smart_Product(SmartVO vo) {
        String sql_insert = "insert into tbl_product_201909 values(?,?,?,?,?)";
        PreparedStatement pstmt = SmartMysqlManager.con(sql_insert);

        try {
            pstmt.setString(1, vo.getP_code());
            pstmt.setString(2, vo.getP_name());
            pstmt.setString(3, vo.getP_size());
            pstmt.setString(4, vo.getP_type());
            pstmt.setInt(5, vo.getP_price());
            pstmt.executeUpdate();
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    public void insert_Smart_Worklist(SmartVO vo){
        String sql = "insert into tbl_worklist_201909 values (?,?,?,?)";
        PreparedStatement pstmt = SmartMysqlManager.con(sql);
        try{
            pstmt.setString(1,vo.getW_workno());
            pstmt.setString(2,vo.getP_code());
            pstmt.setInt(3,vo.getW_quentity());
            pstmt.setString(4,vo.getW_workdate());
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insert_Smart_Process(SmartVO vo){
        String sql = "insert into tbl_process_201909 values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = SmartMysqlManager.con(sql);
        int cnt =1;
        try{
            pstmt.setString(1,vo.getW_workno());
            List<String> list = vo.getP_px();
            for(String p_p : list){
                cnt++;
                pstmt.setString(cnt,p_p);
            }
            pstmt.setString(8,vo.getW_lastdate());
            pstmt.setString(9,vo.getW_lasttime());
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //select
    public List<SmartVO> select_All_Smart_Product() {
        String select_Product = "select * from tbl_product_201909";
        PreparedStatement pstmt = SmartMysqlManager.con(select_Product);
        ResultSet rs = null;
        ArrayList list = new ArrayList();

        try {
            rs = pstmt.executeQuery();

            while(rs.next()) {
                SmartVO vo = new SmartVO();
                vo.setP_code(rs.getString("p_code"));
                vo.setP_name(rs.getString("p_name"));
                vo.setP_size(rs.getString("p_size"));
                vo.setP_type(rs.getString("p_type"));
                vo.setP_price(rs.getInt("p_price"));
                list.add(vo);
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        } finally {
            SmartMysqlManager.close(pstmt, rs);
        }

        return list;
    }

    public List<SmartVO> select_All_Product_And_Worklist(){
        String sql ="select * from tbl_worklist_201909 wl, tbl_product_201909 pro where wl.p_code=pro.p_code group by w_workno;";
        List<SmartVO> list =  new ArrayList<>();
        PreparedStatement pstmt = SmartMysqlManager.con(sql);
        ResultSet rs = null;
        try {
            rs = pstmt.executeQuery();
            while (rs.next()){
                SmartVO vo = new SmartVO();
                vo.setP_code(rs.getString("wl.p_code"));
                vo.setW_workno(change_workno(rs.getString("w_workno")));
                vo.setP_name(rs.getString("p_name"));
                vo.setP_size(rs.getString("p_size"));
                vo.setP_type(rs.getString("p_type"));
                vo.setW_quentity(rs.getInt("w_quentity"));
                vo.setW_workdate(change_workdate_hi(rs.getString("w_workdate")));
                list.add(vo);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<SmartVO> select_All_Process(){
        String sql ="select * from tbl_process_201909";
        List<SmartVO> list =  new ArrayList<>();
        PreparedStatement pstmt = SmartMysqlManager.con(sql);
        ResultSet rs = null;
        try{
            rs = pstmt.executeQuery();

            while (rs.next()){

                SmartVO vo = new SmartVO();
                vo.setW_workno(rs.getString("w_workno"));
                int cnt=1;
                List<String> list2 =  new ArrayList<>();
                while (cnt!=7){
                    list2.add(rs.getString("p_p"+cnt));
                    cnt++;
                }
                vo.setP_px(list2);
                vo.setW_lastdate(rs.getString("w_lastdate"));
                vo.setW_lasttime(rs.getString("w_lasttime"));
                list.add(vo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            SmartMysqlManager.close(pstmt,rs);
        }
        return list;
    }

    public List<SmartVO> select_All_Pro_And_Work_And_process(){
        String sql = "select pros.w_workno, wl.p_code, p_name, p_p1,p_p2,p_p3,p_p4,p_p5,p_p6, w_lastdate,w_lasttime "  +
                "from tbl_product_201909 pro, tbl_worklist_201909 wl, tbl_process_201909 pros " +
                "where pro.p_code=wl.p_code and wl.w_workno=pros.w_workno " +
                "group by pros.w_workno;";
        List<SmartVO> list =  new ArrayList<>();
        PreparedStatement pstmt = SmartMysqlManager.con(sql);
        ResultSet rs = null;

        try {
            rs = pstmt.executeQuery();
            while (rs.next()){
                SmartVO vo = new SmartVO();
                vo.setW_workno(rs.getString("w_workno"));
                vo.setP_code(rs.getString("p_code"));
                int cnt=1;
                List<String> list2 =  new ArrayList<>();
                while (cnt!=7){
                    list2.add(check_P_P(rs.getString("p_p"+cnt)));
                    cnt++;
                }
                vo.setP_px(list2);
                vo.setW_lastdate(change_workdate_hi(rs.getString("w_lastdate")));
                vo.setW_lasttime(change_time(rs.getString("w_lasttime")));
                list.add(vo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;

    }


    //기능
    public boolean check_Code(String code) {
        String sql = "select p_code from tbl_product_201909 where p_code=?";
        PreparedStatement stmt = SmartMysqlManager.con(sql);
        boolean check_bool = false;

        try {
            stmt.setString(1, code);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return check_bool;
    }
    public boolean check_work_num(String num) {
        String sql = "select w_workno from tbl_worklist_201909 where w_workno=?";
        PreparedStatement stmt = SmartMysqlManager.con(sql);
        boolean check_bool = false;

        try {
            stmt.setString(1, num);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return check_bool;
    }
    public String check_Worklist_Num() {
        String sql = "select max(w_workno)+1 as max_work from tbl_worklist_201909";
        String num = "20190001";
        PreparedStatement pstmt = SmartMysqlManager.con(sql);
        ResultSet rs = null;
        try {
            rs = pstmt.executeQuery();
            if (rs.next()) {

                num = String.valueOf(rs.getInt("max_work")) ;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    private String check_P_P(String yes_or_no){
        if(yes_or_no.equals("Y")) return "완료";
        else return " ~";
    }

    private String change_workno(String workno){
        String temp_1 = workno.substring(0,4);
        String temp_2 = workno.substring(4,8);
        return temp_1 + "-" + temp_2;
    }

    private String change_workdate(String workdate){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        date.setMonth(Integer.parseInt(workdate.substring(0,2)));
        date.setDate(Integer.parseInt(workdate.substring(2,4)));
        String day =format.format(date);
        return day;
    }

    private String change_workdate_hi(String workdate){
        String workdate_temp =workdate;
        if(workdate.length()!=8){
            workdate_temp= change_workdate(workdate);
        }
        return workdate_temp.substring(0,4) + "-" + workdate_temp.substring(4,6)+"-"+workdate_temp.substring(6,8);

    }

    private String change_time(String time){
        return time.substring(0,2) +":"+ time.substring(2,4);
    }


}
