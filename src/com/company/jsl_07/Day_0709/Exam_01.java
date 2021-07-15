package com.company.jsl_07.Day_0709;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Exam_01 {
    public static void main(String[] args) {
        TreeMap<Integer,String> stringTreeMap = new TreeMap<>();
        stringTreeMap.put(new Integer(87),"이학생");
        stringTreeMap.put(new Integer(88),"오학생");
        stringTreeMap.put(new Integer(82),"하학생");
        stringTreeMap.put(new Integer(81),"미학생");
        stringTreeMap.put(new Integer(83),"키학생");
        stringTreeMap.put(new Integer(85),"지학생");
        stringTreeMap.put(new Integer(86),"김학생");
        Set<Integer> set = stringTreeMap.keySet();
        for(int a : set){
            System.out.println(a);
        }
        Map.Entry<Integer,String> entry = null;
        entry = stringTreeMap.firstEntry();
        System.out.println(entry.getKey());
    }
}
