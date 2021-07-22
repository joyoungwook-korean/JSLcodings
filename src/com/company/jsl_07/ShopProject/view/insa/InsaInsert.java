package com.company.jsl_07.ShopProject.view.insa;

import com.company.jsl_07.ShopProject.model.dao.insaDAO;
import com.company.jsl_07.ShopProject.model.insa.insaVO;
import sun.rmi.server.Activation$ActivationSystemImpl_Stub;

import java.util.Scanner;

public class InsaInsert {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        insaDAO dao = insaDAO.getInstance();
        int sawon=insaDAO.insa_Max();
        insaVO vo = new insaVO();
        vo.setSawon(sawon);
        System.out.print("사원 번호 : " +sawon + "\n");
        System.out.print("성명 : " );
        vo.setName(scanner.next());
        scanner.nextLine();
        System.out.print("직책 : " );
        vo.setDuty(scanner.next());
        scanner.nextLine();
        System.out.print("연락처 : " );
        vo.setPhone(scanner.next());
        scanner.nextLine();
        String today = insaDAO.getDate();
        System.out.print("입사일자 : " + "("+today+")" );
        vo.setIndate(scanner.nextLine());
        if(vo.getIndate() == null){
            vo.setIndate(today);
        }
        scanner.nextLine();
        System.out.print("퇴사일자 : " );
        String s = scanner.nextLine();
        if(s.isEmpty()) vo.setOutdate(null);
        else vo.setOutdate(s);
        System.out.print("부서코드 : " );
        vo.setDcode(scanner.next());
        dao.insa_Insert(vo);
    }
}
