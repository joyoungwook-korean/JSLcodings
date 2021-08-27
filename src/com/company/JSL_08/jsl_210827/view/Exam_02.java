package com.company.JSL_08.jsl_210827.view;

import com.company.JSL_08.jsl_210827.model.OilDao;

import java.util.Map;

public class Exam_02 {
    public static void main(String[] args) {
        OilDao oilDao = OilDao.getOilDao();
        System.out.println("주유일자 \t 유종  \t  건수 \t 금액");
        for(Map<String,Object> map : oilDao.oil_Exam_02()){
            System.out.println(map.get("OILDATE") + " \t " +map.get("OILNAME")+ " \t " +map.get("GUN")+ " \t " +map.get("OIL_SUM"));
        }
    }
}
