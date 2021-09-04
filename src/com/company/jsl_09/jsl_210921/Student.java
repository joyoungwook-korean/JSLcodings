package com.company.jsl_09.jsl_210921;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class Student implements Serializable,Comparable<Student> { // ��ü����ȭ Serializable
    private String bun;
    private String name;
    private int kor,eng,mat;
    private int tot;
    private double avg;
    private String hakjum;
    public Student() {}
    public Student(String bun,String name,int kor,int eng,int mat) {
        this.bun=bun;
        this.name=name;
        this.kor=kor;
        this.eng=eng;
        this.mat=mat;
        totAvg();
    }
    public String getBun() {
        return bun;
    }
    public void setBun(String bun) {
        this.bun = bun;
    }
    public int getKor() {
        return kor;
    }
    public void setKor(int kor) {
        this.kor = kor;
    }
    public int getEng() {
        return eng;
    }
    public void setEng(int eng) {
        this.eng = eng;
    }
    public int getMat() {
        return mat;
    }
    public void setMat(int mat) {
        this.mat = mat;
    }
    public int getTot() {
        return tot;
    }
    public void setTot(int tot) {
        this.tot = tot;
    }

    private void totAvg() {
        tot = kor+eng+mat;
        avg = (int)(tot/3.*100+0.5)/100.;
        hakJum();
    }
    private void hakJum() {
        if(avg>=90)
            hakjum="A";
        else if(avg>=80)
            hakjum="B";
        else if(avg>=70)
            hakjum="C";
        else if(avg>=60)
            hakjum="D";
        else
            hakjum="F";
    }
    @Override
    public String toString() {
        return bun+"\t"+name+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+tot+"\t"+avg+"\t"+hakjum;
    }
    @Override
    public int compareTo(Student o) {
        return Integer.compare(Integer.parseInt(bun),Integer.parseInt(o.bun));
    }

}

