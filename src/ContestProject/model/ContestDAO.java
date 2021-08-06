package ContestProject.model;

import ContestProject.util.ContestMysqlManager;
import javafx.collections.transformation.SortedList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContestDAO {
    public ContestDAO() {
    }

    private static ContestDAO instance = new ContestDAO();

    public static ContestDAO getInstance() {
        return instance;
    }

    //insert
    public void insert_to_entry(ContestVO vo) {
        String sql = "insert into tbl_entry_202106 values (?,?,?,?,?)";
        PreparedStatement pstmt = ContestMysqlManager.con(sql);
        try {
            pstmt.setString(1, vo.getEntry_no());
            pstmt.setString(2, vo.getEntry_name());
            pstmt.setString(3, vo.getEntry_jumin());
            pstmt.setString(4, vo.getEntry_type());
            pstmt.setString(5, vo.getEntry_area());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert_to_record(ContestVO vo) {
        String sql = "insert into tbl_record_202106 values (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = ContestMysqlManager.con(sql);
        int cnt = 2;
        try {
            int sum_temp = 0;
            pstmt.setString(1, vo.getEntry_no());
            for (int temp : vo.getScore()) {
                pstmt.setInt(cnt, temp);
                sum_temp += temp;
                cnt++;
            }
            for (int i = 0; i < max_min_Sum(vo.getScore()).size(); i++) {
                int temp = max_min_Sum(vo.getScore()).get(i);
                pstmt.setInt(cnt, temp);
                cnt++;
            }
            System.out.println(sum_temp);
            double ave = sum_temp / (float) vo.getScore().size();
            ave = (Math.round(ave * 100) / 100.0);
            pstmt.setDouble(cnt, ave);
            pstmt.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //select
    public List<ContestVO> select_to_entry() {
        String sql = "select * from tbl_entry_202106";
        PreparedStatement pstmt = ContestMysqlManager.con(sql);
        ContestVO vo = null;
        List<ContestVO> list = new ArrayList<>();
        try {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                vo = new ContestVO();
                vo.setEntry_no(rs.getString("entry_no"));
                vo.setEntry_name(rs.getString("entry_name"));
                vo.setEntry_jumin(rs.getString("entry_jumin"));
                vo.setEntry_type(rs.getString("entry_type"));
                vo.setEntry_area(rs.getString("entry_area"));
                list.add(vo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ContestVO> select_re() {
        String sql = "select * from tbl_referee_202106";
        PreparedStatement pstmt = ContestMysqlManager.con(sql);
        ContestVO vo = null;
        List<ContestVO> list2 = new ArrayList<>();
        List list = null;
        try {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list = new ArrayList();
                int cnt = 1;
                while (true) {
                    vo = new ContestVO();

                    String temp = "rname" + cnt;
                    list.add(rs.getString(temp));
                    if (cnt == 5) {
                        vo.setRname(list);
                        list2.add(vo);
                        break;
                    }
                    cnt++;

                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list2;
    }

    public List<ContestVO> select_all_rank(){
        String sql = "select re.entry_no," +
                "       entry_name," +
                "       entry_jumin," +
                "       entry_area,\n" +
                "       entry_type,\n" +
                "       s_tot,\n" +
                "       s_ave " +
                "from tbl_entry_202106 as en,\n" +
                "     tbl_record_202106 as re " +
                "where re.entry_no = en.entry_no " +
                "order by s_ave desc, entry_name desc ";
        PreparedStatement pstmt = ContestMysqlManager.con(sql);
        List<ContestVO> list = new ArrayList<>();
        try {
            ResultSet rs = pstmt.executeQuery();
            int cnt=1;
            while (rs.next()){
                ContestVO vo = new ContestVO();
                vo.setEntry_no(rs.getString("entry_no"));
                String jumin = rs.getString("entry_jumin");
                vo.setEntry_name(rs.getString("entry_name")+"(" + gender(jumin) +")");
                vo.setEntry_jumin(change_birth(jumin));
                vo.setEntry_type(change_Type(rs.getString("entry_type")));
                vo.setEntry_area(rs.getString("entry_area"));
                vo.setTot(rs.getInt("s_tot"));
                vo.setAve(rs.getDouble("s_ave"));
                vo.setMax(cnt);
                cnt++;
                list.add(vo);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<ContestVO> select_to_record() {
        String sql = "select * from tbl_record_202106";
        PreparedStatement pstmt = ContestMysqlManager.con(sql);
        ContestVO vo = null;
        List<ContestVO> list = new ArrayList<>();

        try {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                vo = new ContestVO();
                List<Integer> score = new ArrayList<>();
                vo.setEntry_no(rs.getString("entry_no"));
                score.add(rs.getInt("score1"));
                score.add(rs.getInt("score2"));
                score.add(rs.getInt("score3"));
                score.add(rs.getInt("score4"));
                score.add(rs.getInt("score5"));
                score.add(rs.getInt("s_max"));
                score.add(rs.getInt("s_min"));
                score.add(rs.getInt("s_tot"));
                vo.setAve(rs.getDouble("s_ave"));
                vo.setScore(score);
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ContestVO select_Record_alone(String entry_no){
        String sql = "select re.entry_no, entry_name, entry_jumin, entry_type, entry_area, score1,score2,score3,score4,score5,s_tot,s_ave " +
                "from tbl_entry_202106 en, tbl_record_202106 re " +
                "where re.entry_no = ? and en.entry_no=?";
        PreparedStatement pstmt = ContestMysqlManager.con(sql);
        ContestVO vo = new ContestVO();
        try {
            pstmt.setString(1,entry_no);
            pstmt.setString(2,entry_no);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                vo.setEntry_no(rs.getString("entry_no"));
                String jumin = rs.getString("entry_jumin");
                vo.setEntry_name(rs.getString("entry_name")+"(" + gender(jumin) +")");
                vo.setEntry_jumin(change_birth(jumin));
                vo.setEntry_type(change_Type(rs.getString("entry_type")));
                vo.setEntry_area(rs.getString("entry_area"));
                List<Integer> score = new ArrayList<>();
                score.add(rs.getInt("score1"));
                score.add(rs.getInt("score2"));
                score.add(rs.getInt("score3"));
                score.add(rs.getInt("score4"));
                score.add(rs.getInt("score5"));
                score.add(rs.getInt("s_tot"));
                vo.setAve(rs.getDouble("s_ave"));
                vo.setScore(score);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return vo;
    }


    //기능----------------------==

    private String gender(String jumin){
        if(jumin.substring(6,7).equals("1")) return "남";
        else return "여";
    }

    public String last_EntryNum() {
        String sql = "select max(entry_no) as max from tbl_entry_202106";
        PreparedStatement pstmt = ContestMysqlManager.con(sql);
        String first_num = "0001";
        try {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                first_num = rs.getString("max");
                int temp = Integer.parseInt(first_num);
                temp++;
                first_num = String.valueOf(temp);
                for (int i = first_num.length(); i < 4; i++) {
                    first_num = "0" + first_num;
                }
            } else {
                return first_num;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return first_num;
    }

    public boolean check_jumin(String jumin) {
        String sql = "select entry_jumin from tbl_entry_202106 where entry_jumin=?";
        boolean check = false;

        try {
            PreparedStatement pstmt = ContestMysqlManager.con(sql);
            pstmt.setString(1, jumin);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("이미 등록된 주민번호 입니다.");
                check = false;
            } else {
                check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean check_EntryNum(String entry_no) {
        String sql = "select entry_no from tbl_entry_202106 where entry_no=?";
        boolean check = false;

        try {
            PreparedStatement pstmt = ContestMysqlManager.con(sql);
            pstmt.setString(1, entry_no);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                check = true;
            }
            else {
                System.out.println("참가자 번호가 존재하지 않습니다.");
                check = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean check1_100(int a) {
        if (1 <= a && a <= 100) return true;
        else {
            System.out.println("점수 입력 오류");
            return false;
        }
    }

    public List<Integer> max_min_Sum(List<Integer> list) {
        List<Integer> list_save = new ArrayList<>();
        Collections.sort(list, Collections.reverseOrder());
        list_save.add(list.get(0));
        list_save.add(list.get(list.size() - 1));
        int temp = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            temp += list.get(i);
        }
        list_save.add(temp);
        return list_save;
    }

    public boolean check_recordNum(String entry_no){
        String sql = "select entry_no from tbl_record_202106 where entry_no=?";
        boolean check = false;
        try {
            PreparedStatement pstmt = ContestMysqlManager.con(sql);
            pstmt.setString(1, entry_no);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                check = true;
            }
            else {
                System.out.println("경연 번호가 존재하지 않습니다.");
                check = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    private String change_birth(String bir){
        if(bir==null){
            return "";
        }else{
            String temp[] = new String[3];
            temp[0] = bir.substring(0,2);
            temp[1] = bir.substring(2,4);
            temp[2] = bir.substring(4,6);

            return temp[0] + "년" + temp[1] + "월" + temp[2] +"일";
        }
    }

    private String change_Type(String type){
        if(type.equals("1")){
            return "기악";
        }else if(type.equals("2")){
            return "민요";
        }else if(type.equals("3")){
            return "무용";
        }else{
            return "판소리";
        }
    }
}
