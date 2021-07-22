package com.company.jsl_07.ShopProject.view;

import com.company.jsl_07.ShopProject.model.MoneyVO;
import com.company.jsl_07.ShopProject.model.dao.ShopDAO;

import java.util.Scanner;

public class MoneySearch {
    public static void main(String[] args) {
        ShopDAO dao = ShopDAO.getInstance();
        Scanner scanner = new Scanner(System.in);
        int saleNo = scanner.nextInt();
        MoneyVO moneyVO = dao.money_Check(saleNo);
        if(moneyVO==null){
            System.out.println("없음");
        }else{
            System.out.println(moneyVO);
        }
    }
}
