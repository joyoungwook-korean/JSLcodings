package com.company.JSL_08.jsl_210823.view;

import com.company.JSL_08.jsl_210823.model.ShopDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Shop_03 {
    public static void main(String[] args) {
        ShopDAO dao = new ShopDAO();
        List<Map<String, Object>> list = dao.select_Shop_03();

        for(Map<String,Object> map : list){
            Set set = map.keySet();
            for(Object seta : set){
                System.out.print(map.get(seta) + "  ");
            }
            System.out.println();
        }

        //

        for(Map<String,Object> map : list){
            System.out.println(  map.get("CUSTNO") + "  " +  map.get("CUSTNAME")
                    + "  " +map.get("PHONE")+ "  " +map.get("GENDER")+ "  " +
                    map.get("JOINDATE") + "  " + map.get("GRADE") + "  " + map.get("CITY")
            );
        }
    }
}
