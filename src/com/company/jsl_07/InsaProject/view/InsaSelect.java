package com.company.jsl_07.InsaProject.view;

import com.company.jsl_07.InsaProject.dao.insaDAO;
import com.company.jsl_07.InsaProject.model.insaVO;

import java.util.ArrayList;
import java.util.List;

public class InsaSelect {
    public static void main(String[] args) {
        insaDAO dao = insaDAO.getInstance();
        List<insaVO> vo = new ArrayList<>();
        vo= dao.insa_Select();

        for (insaVO a : vo){
            System.out.println(a);
        }

    }

}
