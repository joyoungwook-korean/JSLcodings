package com.company.jsl_07.Day_0709_test;

import java.util.Objects;

public class Sawon implements Comparable<Sawon>{
    private int sabun;
    private String name;
    private String gender;
    private String birth;
    private int age;

    public Sawon(int sabun, String name, String gender, String birth) {
        this.sabun = sabun;
        this.name = name;
        this.gender = setGender(gender);
        this.birth = birth;
        setAge(birth);
    }

    public void setAge(String birth) {
        String ageS = birth.substring(0,4);
        int agein = Integer.valueOf(ageS);
        if(agein<2000) agein = 2021-(agein-1);
        else agein = 2021-(agein-1);
        this.age=agein;
    }

    public String setGender(String gender) {
        if(gender.equals("m") || gender.equals("M")) gender="남자";
        else gender = "여자";
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sawon sawon = (Sawon) o;
        return sabun == sawon.sabun;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sabun);
    }

    @Override
    public String toString() {
        return
                 sabun +
                "\t" + name +
                "\t" + gender +
                "\t\t" + birth +
                "\t"+ age;
    }



    @Override
    public int compareTo(Sawon o) {
        return Integer.compare(sabun,o.sabun);
    }
}
