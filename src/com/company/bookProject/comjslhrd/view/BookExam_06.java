package com.company.bookProject.comjslhrd.view;

import com.company.bookProject.comjslhrd.model.DAO.BookDAO;
import com.company.bookProject.comjslhrd.model.VO.BookVo;

import java.util.List;

public class BookExam_06 {
    public static void main(String[] args) {
        BookDAO dao = BookDAO.getInstance();
        List<BookVo> list = dao.select_All_Booknow();
        System.out.println("도서코드"+" \t"+"도서이름"+" \t"+"구입년도"+" \t"+"대출건수"+" \t"+"반납건수");

        for(BookVo vo: list){
            String day = vo.getCode_regdate();
            String temp[] = new String[3];
            temp[0] = day.substring(0,4);
            temp[1] = day.substring(4,6);
            temp[2] = day.substring(6,8);
            String a = temp[0]+"-"+temp[1]+"-"+temp[2];
            System.out.print(vo.getBookno() +"\t\t\t"+vo.getBookname()+"\t\t"+a+" \t " +
                             vo.getUserno()+" \t\t"+vo.getLentno());

            System.out.println();
        }

    }
}
