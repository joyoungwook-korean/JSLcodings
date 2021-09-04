package com.company.jsl_09.jsl_210903.view;

import com.company.jsl_09.jsl_210903.dao.AirPollutionDAO;

import java.util.Scanner;

public class Exam_02_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AirPollutionDAO dao = AirPollutionDAO.getConnection();
        System.out.print("관측일자 : ");
        String date = sc.next();
        System.out.print("측정시기(오전:AM, 오후:PM) : ");
        String am_pm = sc.next();
        System.out.print("대기오염코드(P1:미세번지,P2:오존,P3:자외선,P4:황사) : ");
        String code = sc.next();
        System.out.print("관측지점번호 : ");
        String num = sc.next();
        System.out.print("측정값 : ");
        int val = sc.nextInt();
        dao.insert_Test(date,am_pm,code,num,val);
        dao.view_03(dao.select_Test_03());


    }
}
