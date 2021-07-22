package com.company.jsl_07.InsaProject.view;

import com.company.jsl_07.InsaProject.dao.insaDAO;
import com.company.jsl_07.InsaProject.model.insaVO;

import java.util.Scanner;

public class InsaGet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        insaDAO dao = insaDAO.getInstance();

        System.out.print("사원번호 : ");
        insaVO vo = dao.insa_getChk(scanner.nextInt());
        if(vo==null) System.out.print("등록된 사원이 없습니다");
        else{
            System.out.print("직책 : "+ vo.getName() +"\n");
            System.out.print("연락처 : "+ vo.getPhone() +"\n");
            System.out.print("입사일자 : "+ vo.getIndate() +"\n");
            System.out.print("퇴사일자 : "+ vo.getOutdate() +"\n");
            System.out.print("부서코드 : "+ vo.getDcode() +"\n");
        }
    }
}
