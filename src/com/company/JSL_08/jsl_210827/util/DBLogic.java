package com.company.JSL_08.jsl_210827.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBLogic {
    private static Connection conn = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    //생성자로 받을시
    public DBLogic(Connection conn) {
        this.conn = conn;
    }

    public DBLogic() {
        System.out.println("객체가 생성되었습니다. Connection을 연결시켜 주세요.");
    }
    //set으로 받을 시
    public void setConn(Connection conn) {
        this.conn = conn;
    }


    //조회문 List<Map> 형식으로 반환 테이블명(String), 값(Object)
    //-------Select 문
     public List<Map<String,Object>> con_Select(String sql) {

        List<Map<String, Object>> list_map = new ArrayList<>();
        Map<String, Object> map;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

           ResultSetMetaData setMetaData = rs.getMetaData();
            int sizeOfColums = setMetaData.getColumnCount();
            String column;
            while (rs.next()){
                map = new HashMap<>();
                for(int i = 1; i<=sizeOfColums; i++){
                    column = setMetaData.getColumnName(i);
                    map.put(column,rs.getString(column));
                }
                list_map.add(map);
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return list_map;
    }
     public List<Map<String,Object>> con_Select(String sql,Object ... pstmt_input) {
        List<Map<String, Object>> list_map = new ArrayList<>();
        Map<String, Object> map;
        int cnt=0;
        try {
            pstmt = conn.prepareStatement(sql);
            for(Object s : pstmt_input){
                if(s instanceof Number){
                    pstmt.setInt(++cnt,((Number) s).intValue());
                }else if(s instanceof String) {
                    pstmt.setString(++cnt, s.toString());
                }
            }
            rs = pstmt.executeQuery();
            //ResultSet의 데이터를 읽어와서 set에 저장
            ResultSetMetaData setMetaData = rs.getMetaData();
            //setMetaData에서의 컬럼카운트를 읽어옴
            int sizeOfColums = setMetaData.getColumnCount();
            String column;
            while (rs.next()){
                //한번 할때마다 해쉬맵을 생성
                map = new HashMap<>();
                //컬럼 컬럼 사이즈 만큼 for문을 돌림
                for(int i = 1; i<=sizeOfColums; i++){
                    //컬럼 name을 읽어서 온다.
                    column = setMetaData.getColumnName(i);
                    // 맵에 컬럼명과 값을 String으로 넣는다.
                    map.put(column,rs.getString(column));
                }
                //반환받은 rs를 리스트에 추가한다.
                list_map.add(map);
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return list_map;
    }

    // -------------Insert Delete 문
    public void con_Update(String sql){
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (Exception var3) {
            var3.printStackTrace();
        }
    }
    public void con_Update(String sql, Object ... pstmt_input) {

        int cnt =0;
        try {
            pstmt = conn.prepareStatement(sql);
            for(Object s : pstmt_input){
                if(s instanceof Number){
                    pstmt.setInt(++cnt,((Number) s).intValue());
                }else if(s instanceof String) {
                    pstmt.setString(++cnt, s.toString());
                }
            }
            pstmt.executeUpdate();
        } catch (Exception var3) {
            var3.printStackTrace();
        }
    }




    //닫기
    public void close() {
        try {
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

}
