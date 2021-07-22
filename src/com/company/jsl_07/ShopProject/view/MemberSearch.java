package com.company.jsl_07.ShopProject.view;

import com.company.jsl_07.ShopProject.model.MemberVO;
import com.company.jsl_07.ShopProject.model.dao.ShopDAO;

import java.util.Scanner;

public class MemberSearch {
    public static void main(String[] args) {
        ShopDAO dao = ShopDAO.getInstance();
        Scanner scn = new Scanner(System.in);
        System.out.println("회원정보 검색 화면");
        System.out.println("회원 번호 : ");
        int custno = scn.nextInt();

        MemberVO vo = dao.member_CustNo_Check(custno);
        if(vo==null){
            System.out.println("없음");
        }else{
            System.out.println(vo);
        }
    }
}
