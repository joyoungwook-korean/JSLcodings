package aritistProject.artist.model;

import aritistProject.artist.util.ArtistMysqlManager;
import com.company.jsl_07.InsaProject.util.MysqlManager;

import javax.naming.ldap.PagedResultsControl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {
    private ArtistDAO(){}
    private static ArtistDAO instance= new ArtistDAO();
    public static ArtistDAO getInstance(){
        return instance;
    }

    public void insert_artist(ArtistVO vo){
        String query="insert into tbl_artist_201905 values (?,?,?,?,?,?)";
        PreparedStatement pstmt = ArtistMysqlManager.con(query);
        try{
            pstmt.setString(1,vo.getArtist_id());
            pstmt.setString(2,vo.getArtist_name());
            pstmt.setString(3,vo.getArtist_gender());
            pstmt.setString(4,vo.getArtist_birth());
            pstmt.setString(5,vo.getTalent());
            pstmt.setString(6,vo.getAgency());
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ArtistMysqlManager.close(pstmt);
            System.out.print("등록이 완료되었습니다");
        }
    }

    public void insert_point(ArtistVO vo){
        String query="insert into tbl_point_201905 values (?,?,?,?)";
        PreparedStatement pstmt = ArtistMysqlManager.con(query);
        try{
            pstmt.setInt(1,vo.getSerial_no());
            pstmt.setString(2,vo.getArtist_id());
            pstmt.setString(3,vo.getMento_id());
            pstmt.setInt(4,vo.getPoint());
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<ArtistVO> select_Artist(){
        String sql = "select * from tbl_artist_201905";
        PreparedStatement pstmt = ArtistMysqlManager.con(sql);
        ArtistVO vo = null;
        List<ArtistVO> list = new ArrayList<>();
        ResultSet rs = null;
        try{
            rs = pstmt.executeQuery();
            while (rs.next()){
                vo = new ArtistVO();
                vo.setArtist_id(rs.getString("artist_id"));
                vo.setArtist_name(rs.getString("artist_name"));
                vo.setArtist_birth(change_birth(rs.getString("artist_birth")));
                vo.setArtist_gender(change_gender(rs.getString("artist_gender")));
                vo.setTalent(change_tal(rs.getString("talent")));
                vo.setAgency(rs.getString("agency"));
                list.add(vo);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ArtistMysqlManager.close(pstmt,rs);
        }

        return list;
    }

    public List<ArtistVO> select_point(){
        String sql = "select * from tbl_point_201905";
        PreparedStatement pstmt = ArtistMysqlManager.con(sql);
        ArtistVO vo = null;
        List<ArtistVO> list = new ArrayList<>();
        ResultSet rs = null;
        try{
            rs = pstmt.executeQuery();
            while (rs.next()){
                vo = new ArtistVO();
                vo.setSerial_no(rs.getInt("serial_no"));
                vo.setArtist_id(rs.getString("artist_id"));
                vo.setMento_id(rs.getString("mento_id"));
                vo.setPoint(rs.getInt("point"));
                list.add(vo);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ArtistMysqlManager.close(pstmt,rs);
        }

        return list;
    }

    public List<ArtistVO> select_Join_Mento(){
        String sql = "select p.serial_no, a.artist_id, artist_name, a.artist_birth, p.point, m.mento_name " +
                "        from tbl_artist_201905 a,tbl_point_201905 p, tbl_mento_201905 m " +
                "        where a.artist_id=p.artist_id and p.mento_id=m.mento_id " +
                "        group by serial_no";
        PreparedStatement pstmt = ArtistMysqlManager.con(sql);
        ArtistVO vo = null;
        List<ArtistVO> list = new ArrayList<>();
        ResultSet rs = null;
        try{
            rs = pstmt.executeQuery();
            while (rs.next()){
                vo = new ArtistVO();
                vo.setSerial_no(rs.getInt("serial_no"));
                vo.setArtist_id(rs.getString("artist_id"));
                vo.setMento_name(rs.getString("mento_name"));
                int point  = rs.getInt("point");
                vo.setPoint(point);
                vo.setString_Point(get_Point_String(point));
                vo.setArtist_name(rs.getString("artist_name"));
                vo.setArtist_birth(change_birth(rs.getString("artist_birth")));
                list.add(vo);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ArtistMysqlManager.close(pstmt,rs);
        }

        return list;

    }

    public List<ArtistVO> select_Join_Max_mem(){
        String sql = "select sum(p.point) as sum ,a.artist_id, artist_name, artist_gender, count(p.artist_id=a.artist_id) as aa " +
                "from tbl_artist_201905 as a,tbl_point_201905 as p " +
                "where a.artist_id=p.artist_id " +
                "group by artist_id " +
                "order by sum desc";
        PreparedStatement pstmt = ArtistMysqlManager.con(sql);
        ArtistVO vo = null;
        List<ArtistVO> list = new ArrayList<>();
        ResultSet rs = null;
        int cnt=1;
        try{
            rs = pstmt.executeQuery();
            while (rs.next()){
                vo = new ArtistVO();
                vo.setArtist_id(rs.getString("artist_id"));
                vo.setArtist_name(rs.getString("artist_name"));
                int point = rs.getInt("sum");
                vo.setPoint(point);
                vo.setSerial_no(cnt);
                cnt++;
                vo.setAvg(point/(float)rs.getInt("aa"));
                vo.setArtist_gender(change_gender(rs.getString("artist_gender")));
                list.add(vo);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ArtistMysqlManager.close(pstmt,rs);
        }

        return list;
    }

    public void update_point(int serial_no, int point){
        String sql = "update tbl_point_201905 set point=? where serial_no=?";
        PreparedStatement pstmt = ArtistMysqlManager.con(sql);
        try{
            pstmt.setInt(1,point);
            pstmt.setInt(2,serial_no);
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete_Artist(String artist_id){
        String sql = "delete from tbl_artist_201905 where artist_id=?";
        PreparedStatement pstmt = ArtistMysqlManager.con(sql);
        try{
            pstmt.setString(1,artist_id);
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete_Point(int serial_no){
        String sql = "delete from tbl_point_201905 where serial_no=?";
        PreparedStatement pstmt = ArtistMysqlManager.con(sql);
        try{
            pstmt.setInt(1,serial_no);
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }





    private static String change_gender(String gender){
        if(gender.equals("M")){
            return "남자";
        }else{
            return "여자";
        }
    }

    private static String change_birth(String bir){
        if(bir==null){
            return "";
        }else{
            String temp[] = new String[3];
            temp[0] = bir.substring(0,4);
            temp[1] = bir.substring(4,6);
            temp[2] = bir.substring(6,8);

            return temp[0] + "년" + temp[1] + "월" + temp[2] +"일";
        }
    }

    private static String change_tal(String tal){
        if(tal.equals("1")){
            return "댄스";
        }else if(tal.equals("2")){
            return "노래";
        }else{
            return "랩";
        }
    }

    private static String get_Point_String(int point){
        if(point>=90){
            return "A";
        }else if(point>=80){
            return "B";
        }else if(point>=70){
            return "C";
        }else if(point>=60){
            return "D";
        }else return "F";
    }
}
