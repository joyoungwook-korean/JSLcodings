package com.company.jsl_07.ShopProject.view;

import com.company.jsl_07.ShopProject.model.CommVO;
import com.company.jsl_07.ShopProject.model.dao.ShopDAO;

import java.util.List;

public class JoinSelect_01 {
    public static void main(String[] args) {
        ShopDAO dao = ShopDAO.getInstance();
        List<CommVO> listaa = dao.joinSelect_01();
        System.out.println("번호\t 이름\t 전화\t 성별\t 날짜\t 등급\t 도시");

        for(CommVO commVO : listaa){
            System.out.print(commVO.getCustno()
                    +" \t"+commVO.getCustname()
                    +" \t"+commVO.getPhone()
                    +" \t"+commVO.getGender()
                    +" \t"+commVO.getJoindate()
                    +" \t"+commVO.getGrade()
                    +" \t"+commVO.getCityName());
            System.out.println();
        }
    }




}
