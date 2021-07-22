package com.company.jsl_07.ShopProject.view;

import com.company.jsl_07.ShopProject.model.CommVO;
import com.company.jsl_07.ShopProject.model.dao.ShopDAO;

import java.util.List;

public class Group {
    public static void main(String[] args) {
        ShopDAO dao = ShopDAO.getInstance();
        List<CommVO> listaa = dao.group_01();
        System.out.println("번호\t 이름\t 전화\t 성별\t 날짜\t 등급\t 도시");

        for(CommVO commVO : listaa){
            System.out.print(commVO.getCustno()
                    +" \t"+commVO.getCustname()
                    +" \t"+commVO.getPhone()
                    +" \t"+commVO.getGrade()
                    +" \t"+commVO.getSum());
            System.out.println();
        }
    }
}
