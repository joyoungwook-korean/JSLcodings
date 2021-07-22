package com.company.jsl_07.InsaProject.view;

import com.company.jsl_07.InsaProject.dao.insaDAO;
import com.company.jsl_07.InsaProject.model.insaVO;

import java.util.List;

public class InsaGroup {
    public static void main(String[] args) {
        insaDAO dao  = insaDAO.getInstance();
        List<insaVO> list = dao.insa_group_Select();
        for(insaVO vo : list){
            System.out.print(vo.getDcode() + "\t" + vo.getDname()+ "\t" +vo.getInwon() + "\t" +vo.getDuty()+"\n");
        }

    }
}
