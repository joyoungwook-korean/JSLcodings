package com.company.jsl_07.ShopProject.view;


import com.company.jsl_07.ShopProject.model.MemberVO;
import com.company.jsl_07.ShopProject.model.ShopDAO;

import java.util.Scanner;

public class MemberInsert {

    public static void main(String[] args) {
        ShopDAO dao = ShopDAO.getInstance();
        MemberVO vo = new MemberVO();
        Scanner scanner = new Scanner(System.in);
        System.out.println("회원 정보 등록 화면 ");
        int custNo = dao.custnoMax();
        System.out.println("회원 번호 " + custNo);
        vo.setCustno(custNo);
        System.out.print("회원 성명 ");
        vo.setCustname(scanner.nextLine());
        System.out.print("회원 전화 ");
        vo.setPhone(scanner.nextLine());
        System.out.print("성별(M/F) ");
        vo.setGender(scanner.nextLine());
        String today = dao.getDate();
        System.out.println("가입일자 " + today);
        vo.setJoindate(today);
        System.out.print("고객 등급 ");
        vo.setGrade(scanner.nextLine().toUpperCase());
        System.out.print("도시 코드 ");
        vo.setCity(scanner.nextLine());
        int row = dao.memberInsert(vo);
        System.out.println(row);
    }

}
