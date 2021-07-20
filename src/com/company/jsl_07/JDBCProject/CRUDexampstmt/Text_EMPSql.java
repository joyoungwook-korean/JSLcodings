package com.company.jsl_07.JDBCProject.CRUDexampstmt;

public class Text_EMPSql {
    public static void main(String[] args) {
        EmpSQL empSQL = new EmpSQL();
        
        int row = empSQL.insert_dept(100,"sasa","ddddd");
        if(row ==1 ){
            System.out.println("생성완료");
        }else{
            System.out.println("생성 실패");
        }
    }
}
