package com.company.jsl_07.ShopProject.view;


import com.company.jsl_07.ShopProject.model.MemberVO;
import com.company.jsl_07.ShopProject.model.ShopDAO;

import java.util.ArrayList;
import java.util.List;

public class MemberSelect {
    public static void main(String[] args) {
        ShopDAO dao = ShopDAO.getInstance();
        System.out.println("회원번호\t회원성명\t 전화번호\t\t성별\t\t가입일자\t 고객등급\t 거주지");

        List<MemberVO> member= dao.memberList();

        for(MemberVO m : member){
            System.out.println(m);
        }

    }
}
