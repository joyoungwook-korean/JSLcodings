package StudentProject.model;

import StudentProject.util.StudentMysqlManager;
import aritistProject.artist.model.ArtistVO;
import aritistProject.artist.util.ArtistMysqlManager;
import org.omg.PortableInterceptor.TRANSPORT_RETRY;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public StudentDAO() {
    }
    private static StudentDAO instance = new StudentDAO();
    public static StudentDAO getInstance() { return instance;}

    // insert
    public void insert_Student(StudentVO vo){
        String query="insert into tbl_student_201905 values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = StudentMysqlManager.con(query);

        try{
            pstmt.setString(1,vo.getSyear());
            pstmt.setString(2,vo.getSclass());
            pstmt.setString(3,vo.getSno());
            pstmt.setString(4,vo.getSname());
            pstmt.setString(5,vo.getBirth());
            pstmt.setString(6,vo.getGender());
            String[] subphone = subPhone(vo.getPhone());
            pstmt.setString(7,subphone[0]);
            pstmt.setString(8,subphone[1]);
            pstmt.setString(9,subphone[2]);
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ArtistMysqlManager.close(pstmt);
        }
    }

    public void insert_Score(StudentVO vo){
        String query="insert into tel_score_201905 values (?,?,?,?,?,?)";
        PreparedStatement pstmt = StudentMysqlManager.con(query);
        try {
            pstmt.setString(1,vo.getSyear());
            pstmt.setString(2,vo.getSclass());
            pstmt.setString(3,vo.getSno());
            pstmt.setInt(4,vo.getKor());
            pstmt.setInt(5,vo.getEng());
            pstmt.setInt(6,vo.getMat());
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //select
    public List<StudentVO> select_Student(){
        String sql = "select * from tbl_student_201905";
        List<StudentVO> list = new ArrayList<>();
        PreparedStatement pstmt = StudentMysqlManager.con(sql);
        ResultSet rs = null;
        try {
            rs = pstmt.executeQuery();
            while (rs.next()){
                StudentVO vo = new StudentVO();
                vo.setSyear(rs.getString("syear"));
                vo.setSclass(rs.getString("sclass"));
                vo.setSno(rs.getString("sno"));
                vo.setSname(rs.getString("sname"));
                vo.setBirth(print_Birth(rs.getString("birth")));
                vo.setGender(check_gender(rs.getString("gender")));
                vo.setPhone(rs.getString("tel1") + "-" +
                        rs.getString("tel2")+ "-" +
                        rs.getString("tel3"));
                list.add(vo);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<StudentVO> select_Score(){
        String sql = "select st.syear,st.sclass,st.sno,st.sname,kor,eng,mat " +
                "from tel_score_201905 sc, tbl_student_201905 st " +
                "where sc.syear=st.syear and sc.sno = st.sno and  sc.sclass = st.sclass";
        List<StudentVO> list = new ArrayList<>();
        PreparedStatement pstmt = StudentMysqlManager.con(sql);
        ResultSet rs = null;
        try {
            rs = pstmt.executeQuery();
            while (rs.next()){
                StudentVO vo = new StudentVO();
                vo.setSyear(rs.getString("syear"));
                vo.setSclass(rs.getString("sclass"));
                vo.setSno(rs.getString("sno"));
                vo.setSname(rs.getString("sname"));
                vo.setKor(rs.getInt("kor"));
                vo.setEng(rs.getInt("eng"));
                vo.setMat(rs.getInt("mat"));
                vo.setTot(vo.getTot());
                vo.setAvg();
                list.add(vo);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<StudentVO> select_Stu_Sco(){
        String sql = "select group_concat(st.syear,'-' ,st.sno,'-' ,st.sclass)as group1 ,gender, sname, kor,eng,mat " +
                "from tel_score_201905 sc, tbl_student_201905 st " +
                "where sc.syear=st.syear and sc.sno = st.sno and  sc.sclass = st.sclass " +
                "group by  st.syear, st.sno, st.sclass";
                List<StudentVO> list = new ArrayList<>();
        PreparedStatement pstmt = StudentMysqlManager.con(sql);
        ResultSet rs = null;
        try {
            rs = pstmt.executeQuery();
            while (rs.next()){
                StudentVO vo = new StudentVO();
                vo.setFull_num(rs.getString("group1"));
                vo.setSname(rs.getString("sname"));
                vo.setGender(check_gender(rs.getString("gender")));
                vo.setKor(rs.getInt("kor"));
                vo.setEng(rs.getInt("eng"));
                vo.setMat(rs.getInt("mat"));
                vo.setTot(vo.getTot());
                vo.setAvg();
                list.add(vo);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<StudentVO> select_Sensei(){
        String sql = "select  st.syear, st.sclass, tname, sum(kor) as kor_sum,sum(eng) as eng_sum,sum(mat) as mat_sum, count(st.sno) as count " +
                "from tel_score_201905 sc, tbl_student_201905 st, tbl_dept_201905 dp " +
                "where sc.syear=st.syear and sc.sno = st.sno and  sc.sclass = st.sclass and dp.sclass = st.sclass " +
                "group by  st.sclass";
        List<StudentVO> list = new ArrayList<>();
        PreparedStatement pstmt = StudentMysqlManager.con(sql);
        ResultSet rs = null;
        try {
            rs = pstmt.executeQuery();
            while (rs.next()){
                StudentVO vo = new StudentVO();
                vo.setSyear(rs.getString("syear"));
                vo.setSclass(rs.getString("sclass"));
                vo.setSensei(rs.getString("tname"));
                vo.setKor(rs.getInt("kor_sum"));
                vo.setEng(rs.getInt("eng_sum"));
                vo.setMat(rs.getInt("mat_sum"));
                vo.setCount(rs.getInt("count"));
                list.add(vo);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    //delete
    public void delete_student(String num){
        String[] sub_num = new String[3];
        sub_num[0] = num.substring(0,1);
        sub_num[1] = num.substring(1,3);
        sub_num[2] = num.substring(3,5);


        if(check_Student(sub_num) ==false){
            String sql = "delete from tel_score_201905 where syear=? and sclass=? and sno=?";
            PreparedStatement pstmt = StudentMysqlManager.con(sql);
            try{
                pstmt.setString(1,sub_num[0]);
                pstmt.setString(2,sub_num[1]);
                pstmt.setString(3,sub_num[2]);
                pstmt.executeUpdate();
                sql = "delete from tbl_student_201905 where syear=? and sclass=? and sno=?";
                pstmt = StudentMysqlManager.con(sql);
                pstmt.setString(1,sub_num[0]);
                pstmt.setString(2,sub_num[1]);
                pstmt.setString(3,sub_num[2]);
                pstmt.executeUpdate();
                System.out.println(num + "의 성적 정보 및 학생 정보가 삭제 되었습니다.");
            }catch (Exception e){
                e.printStackTrace();
            }

        }else{
            System.out.println("학생 정보가 존재하지 않습니다.");
        }

    }






    ///////bi
    private static String[] subPhone(String phone){
        String[] subphone = phone.split(" ");
        return subphone;
    }

    private static String check_gender(String gender){
        if(gender.equals("m") && gender.equals("M")) return "남";
        else return "여";
    }

    private static String print_Birth(String birth){
        String temp[] = new String[3];
        temp[0] = birth.substring(0,4);
        temp[1] = birth.substring(4,6);
        temp[2] = birth.substring(6,8);
        return temp[0] + "년" + temp[1] + "월" + temp[2] +"일";
    }

    public boolean check_Student(String[] check){
        String sql = "select syear,sclass,sno from tbl_student_201905";
        PreparedStatement pstmt = StudentMysqlManager.con(sql);
        ResultSet rs = null;
        boolean bl  = true;
        try{
            rs = pstmt.executeQuery();
            while (rs.next()){
                if(rs.getString("syear").equals(check[0])
                        && rs.getString("sclass").equals(check[1])
                        && rs.getString("sno").equals(check[2])){
                    bl=false;
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return bl;
    }


}
