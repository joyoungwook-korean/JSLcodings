package com.company.jsl_08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OracleTest {
    public static void main(String[] args)  throws Exception {
        String sql = "select * from employee group by job having";

        ResultSet rs = OracleDBManager.con_rs(sql);
        while (rs.next()) {
            System.out.println(rs.getString("eno"));

        }
    }
}
