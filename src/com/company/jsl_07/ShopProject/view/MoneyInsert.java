package com.company.jsl_07.ShopProject.view;



import com.company.jsl_07.ShopProject.model.MoneyVO;
import com.company.jsl_07.ShopProject.model.ShopDAO;


import java.util.Scanner;

public class MoneyInsert {

    public static void main(String[] args) {
        ShopDAO dao = ShopDAO.getInstance();
        MoneyVO vo = new MoneyVO();
        Scanner scanner = new Scanner(System.in);
        int custNum;
        while (true) {
            System.out.print("회원 번호 : ");
            int che = scanner.nextInt();
            custNum = dao.money_CustNo_Check(che);
            if (custNum == 0) {
                continue;
            } else {
                break;
            }
        }
        vo.setCustno(custNum);
        System.out.print("판매 번호 : ");
        vo.setSaleno(scanner.nextInt());
        System.out.print("단가 : ");
        vo.setPcost(scanner.nextInt());
        System.out.print("수량 : ");
        vo.setAmount(scanner.nextInt());
        System.out.print("가격 : ");
        vo.setPrice(scanner.nextInt());
        System.out.print("상품코드 : ");
        vo.setPcode(scanner.next());
        System.out.print("판매 일자 : ");
        vo.setSdate(dao.getDate());
        dao.moneyInsert(vo);

    }

}
