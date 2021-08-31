package com.company.JSL_08.jsl_210827.view;

import com.company.JSL_08.jsl_210827.model.OilDao;

import java.util.List;
import java.util.Map;

public class Exam_01 {
    public static void main(String[] args) {
        OilDao oilDao =  OilDao.getOilDao();
        List<Map<String,Object>> list = oilDao.oil_Exam01();

        System.out.println("매출번호 \t 주유일자 \t 유종 \t 주유량 \t 결제방법 \t 회원성명 \t 회원번호 \t 전화번호 \t\t 카드번호 \t\t 금액");
        for(Map map : list){
            System.out.print(map.get("SALENO") + " \t " + map.get("OILDATE") + " \t " +
                    map.get("OILNAME") + " \t\t " + map.get("AMOUNT") + " \t " + map.get("PAYTYPE")
                    + " \t " + map.get("CUSTNAME") + " \t " + map.get("CUSTNO") + " \t " + map.get("CUSTNAME")
                    + " \t " + map.get("CUSTTEL") + " \t " + map.get("CREDITCARD") + " \t ");
            if(map.get("CREDITCARD").equals("")) System.out.print("    \t\t\t\t" + map.get("OILCOST"));
            else System.out.print(map.get("OILCOST"));
            System.out.println();
        }

        System.out.println("매출 총액 : " + list.get(0).get("SUMCOST"));
    }
}
