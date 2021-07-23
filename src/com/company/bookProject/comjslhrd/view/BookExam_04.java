package com.company.bookProject.comjslhrd.view;

import com.company.bookProject.comjslhrd.model.DAO.BookDAO;
import com.company.bookProject.comjslhrd.model.VO.BookVo;

import java.util.Scanner;

public class BookExam_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookDAO dao = BookDAO.getInstance();
        System.out.print("회원번호 : ");
        int a = scanner.nextInt();
        BookVo vo = dao.find_Select(a);
        if(vo==null){
            System.out.print("등록된 회원이 아닙니다");
        }else{
            System.out.println("회원성명 : "+vo.getName());
            System.out.println("연락처 : "+vo.getPhone_all());
            System.out.println("성별 : "+vo.getGender());
            System.out.println("생년월일 : "+vo.getBirthday());
            System.out.println("가입일자 : "+vo.getRegdate());
        }

    }
}
