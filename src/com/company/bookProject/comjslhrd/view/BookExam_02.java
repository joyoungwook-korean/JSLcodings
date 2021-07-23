package com.company.bookProject.comjslhrd.view;

import com.company.bookProject.comjslhrd.model.DAO.BookDAO;
import com.company.bookProject.comjslhrd.model.VO.BookVo;

import java.util.List;

public class BookExam_02 {
    public static void main(String[] args) {
        BookDAO dao = BookDAO.getInstance();
        List<BookVo> list = dao.select_All_Member();
        for(BookVo vo: list){
            System.out.print(vo);
        }
    }
}
