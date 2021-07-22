package com.company.jsl_07.ShopProject.view;

import com.company.jsl_07.ShopProject.model.MoneyVO;
import com.company.jsl_07.ShopProject.model.dao.ShopDAO;

import java.util.List;

public class MoneySelect {
    public static void main(String[] args) {
        ShopDAO dao = ShopDAO.getInstance();
        List<MoneyVO> list = dao.moneyList();
        System.out.println("회원번호\t판매번호 \t단가 \t수량\t가격 \t상품코드\t판매일자");
        for(MoneyVO vo : list){
            System.out.println(vo);
        }

    }
}
