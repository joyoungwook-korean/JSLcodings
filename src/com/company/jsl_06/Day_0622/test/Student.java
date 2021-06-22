package com.company.jsl_06.Day_0622.test;

import java.util.Objects;

public class Student {
    private int bun;
    private String name;
    private int kor,mat,eng,tot;
    private double avg;

    public Student(int bun, String name, int kor, int mat, int eng) {
        this.bun = bun;
        this.name = name;
        this.kor = kor;
        this.mat = mat;
        this.eng = eng;
    }

    public Student() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return bun == student.bun && student.equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bun, name);
    }

    @Override
    public String toString() {
        tot = kor+eng+mat;
        avg= tot/(float)3;
        avg = Math.round( (avg*100)/100.0);
        return bun+"\t"+name+"\t"+kor+"\t"+mat+"\t"+eng+"\t"+tot+"\t"+avg;
    }
}
