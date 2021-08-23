package com.company.JSL_08.jsl_210823.view;

import com.company.JSL_08.jsl_210823.model.CommVO;
import com.company.JSL_08.jsl_210823.model.ShopDAO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Shop_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShopDAO shopDAO = new ShopDAO();
        CommVO commVO = new CommVO();
        int custNo =  shopDAO.check_CustNo();

        commVO.setCustno(custNo);
        System.out.println("회원 번호 : " +custNo);
        System.out.print("회원 성명 : ");
        commVO.setCustname(scanner.next());
        System.out.print("회원 전화 : ");
        commVO.setPhone(scanner.next());
        System.out.print("성별(M/F) : ");
        commVO.setGender(scanner.next());
        System.out.println("가입 일자 : " +date_time());
        commVO.setJoindate(date_time());
        System.out.print("고객 등급 : ");
        commVO.setGrade(scanner.next());
        System.out.print("도시 코드 : ");
        commVO.setCity(scanner.next());

        shopDAO.update_Shop_01(commVO);
    }

    private static String date_time(){
        String date;
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        date = simpleDateFormat.format(date1);
        return date;
    }
}
