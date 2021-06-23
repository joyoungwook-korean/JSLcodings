package com.company.jsl_06.Day_0623.exam;

import sun.rmi.transport.proxy.CGIHandler;

public class Member {
    String name;
    String phoneNum;
    String juNum;
    String male;
    String s;
    int age;

    public Member(String name,String juNum, String phoneNum ) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.juNum = juNum;
        male = su();
    }

    public Member() {
    }

    String su(){
        s = juNum.substring(7,8);
        age = age(s,juNum);
        if(s.equals("1")|| s.equals("3") || s.equals("5") || s.equals("7")) s = "남";
        else s= "여";
        return s;
    }

    int age(String s,String s1){
        String ageS = s1.substring(0,2);
        int agein = Integer.valueOf(ageS);
        if(s.equals("1") || s.equals("5") || s.equals("2") || s.equals("6")) agein = 2021-(1900+agein-1);
        else agein = 2021-(2000+agein-1);
        return agein;
    }

    @Override
    public String toString() {
        return name + " " + phoneNum + " " + male + " " + age ;
    }
}
