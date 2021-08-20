package project_A_0805.DB_Connection.db.test;

import project_A_0805.DB_Connection.db.util.DBLogic;
import project_A_0805.DB_Connection.db.util.DBManager;
import project_A_0805.DB_Connection.db.util.OracleDBManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBTest {
    //例
    public static void main(String[] args) {
        //sql 문
        /*

        create table test(
    a1 INTEGER primary key ,
    a2 varchar2(30)
    )
         */


        //인터페이스에 OraclDB Connection 연결
        DBManager dbManager = new OracleDBManager();
        //DB Logic 생성자로 Connection 반환
        DBLogic dbLogic = new DBLogic(dbManager.getConnection());

        //인서트문
        String sql = "insert into test values (?, ?)";
        dbLogic.con_Update(sql, 88, "dd");


        // 조회문
        sql = "select * from test";
        List<Map<String, Object>> list = dbLogic.con_Select(sql);
        for (Object b : list) {
            Map<String, Object> map = (HashMap) b;

            System.out.println(map.keySet()); // 컬럼명 알아오기
            //컬럼 명으로 값 알아오기
            System.out.print(" A1 값 : " + map.get("A1") + "\t");
            System.out.println(" A2 값 : " + map.get("A2"));
        }
        //////////////

        //삭제 문
        sql = "delete test where A1= ?";
        dbLogic.con_Update(sql, 88);
        /////

        dbLogic.close();
    }
}
