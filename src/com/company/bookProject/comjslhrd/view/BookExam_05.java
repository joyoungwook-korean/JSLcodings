package com.company.bookProject.comjslhrd.view;

import com.company.bookProject.comjslhrd.model.DAO.BookDAO;
import com.company.bookProject.comjslhrd.model.VO.BookVo;

import java.util.List;

public class BookExam_05 {
    public static void main(String[] args) {
        BookDAO dao = BookDAO.getInstance();
        List<BookVo> list = dao.select_All_Booklent();
        System.out.println("대출번호"+" \t"+"회원번호"+" \t"+"회원성명"+" \t"+"도서명"+" \t\t"+"대출일자"+" \t"+"반납일자");
        for(BookVo vo: list){
            System.out.print(vo.getLentno() +" \t\t"+vo.getUserno()+" \t\t"+vo.getName()+" \t\t"+
                    vo.getBookname()+" \t\t"+vo.getOutdate()+" \t "+vo.getIndate());
            System.out.println();
        }
    }
}
