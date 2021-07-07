package com.company.jsl_07.Day_0707;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam_03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("tall");
        list.add("school");
        list.add("hi");
        list.add("hey");

        int max=-1;
        int temp=0;
        for(int i=0; i<list.size(); i++){
            String s=list.get(i);
            char[] c = s.toCharArray();
            if(c.length>max){
                max=c.length;
                temp = i;
            }
        }
        System.out.println("output : "+list.get(temp));
    }
}
