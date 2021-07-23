package com.company.bookProject.comjslhrd.view;

import com.company.bookProject.comjslhrd.model.DAO.BookDAO;
import com.company.bookProject.comjslhrd.model.VO.BookVo;

import java.util.Scanner;

public class BookExam_01 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        BookDAO dao =BookDAO.getInstance();
        int userno = dao.book_Max();
        BookVo vo = new BookVo();
        System.out.print("회원번호 : " + userno +"\n");
        vo.setUserno(userno);
        System.out.print("회원성명 : ");
        vo.setName(scn.next());
        System.out.print("연락처 : ");
        vo.setPhone_all(scn.next());
        while (true){
            System.out.print("성별 : ");
            String s = scn.next();
            if(s.equals("M") || s.equals("F")){
                vo.setGender(s);
                break;
            }else{
                System.out.print("입력불가");
                continue;
            }
        }
        System.out.print("생년월일 : ");
        vo.setBirthday(scn.next());
        scn.nextLine();
        System.out.print("가입일자 : ");
        String s = scn.nextLine();
        System.out.print(s);
        if(s==null || s.equals("")){
            vo.setRegdate(BookDAO.getDate());
        }else{
            vo.setRegdate(s);
        }
        dao.book_Insert(vo);

    }
}
