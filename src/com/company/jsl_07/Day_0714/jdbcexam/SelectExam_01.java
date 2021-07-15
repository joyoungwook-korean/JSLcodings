package com.company.jsl_07.Day_0714.jdbcexam;

public class SelectExam_01 {
    public static void main(String[] args) {
        MyDao dao = new MyDao();
        dao.makeConn();
        dao.deptList();
        dao.takeDown();

    }
}
